package com.lyh.beans;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lvyanghui
 * 2019/1/16 22:03
 */
public class DefaultBeanFactory implements BeanFactory,BeanDefinitionRegistry,Closeable {
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
    private Map<String,Object> beanMap = new ConcurrentHashMap<String,Object>(256);

    private ThreadLocal<Set<String>> buildingBeans = new ThreadLocal<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    @Override
    public void registryBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessorList.add(beanPostProcessor);
        if(beanPostProcessor instanceof BeanFactoryAware){
            ((BeanFactoryAware) beanPostProcessor).setBeanFactory(this);
        }
    }

    @Override
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition) throws BeanDefinitionRegistryException{

        Objects.requireNonNull(beanName,"beanName不能为空!");
        Objects.requireNonNull(beanDefinition,"beanDefinition不能为空!");

        if(!beanDefinition.validate()){
            throw new BeanDefinitionRegistryException("验证beanDefinition参数不合法");
        }
        if(beanDefinitionMap.containsKey(beanName)){
            throw new BeanDefinitionRegistryException("已经存在beanDefinition");
        }

        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public Object getBean(String beanName) throws Exception{
        return doGetBean(beanName);
    }


    protected Object doGetBean(String beanName) throws Exception {
        Objects.requireNonNull(beanName,"beanName不能为空");

        Object instance = beanMap.get(beanName);
        if(null != instance){
            return instance;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Objects.requireNonNull(beanDefinition, "beanDefinition不能为空");

        Set<String> ingBeans = this.buildingBeans.get();
        if(null == ingBeans){
            ingBeans = new HashSet<>();
            this.buildingBeans.set(ingBeans);
        }

        if(ingBeans.contains(beanName)){
            throw new Exception(beanName + " 循环依赖！" + ingBeans);
        }

        ingBeans.add(beanName);

        Class<?> classType = beanDefinition.getBeanClass();
        if(classType != null){

            if(beanDefinition.getFactoryMethodName() == null){
                instance = createInstanceByConstructor(beanDefinition);
            }else{
                instance = createInstanceByStaticFactoryMethod(beanDefinition);
            }
        }else{
            instance = createInstanceByFactoryMethod(beanDefinition);
        }

        ingBeans.remove(beanName);

        setPropertyDIValues(beanDefinition,instance);

        instance = applyPostProcessBeforeInitialization(beanName,instance);

        doInitMethod(beanDefinition,instance);

        instance = applyPostProcessAfterInitialization(beanName,instance);

        if(beanDefinition.isSingleton()){
            beanMap.put(beanName,instance);
        }

        return instance;
    }

    public Object createInstanceByConstructor(BeanDefinition beanDefinition)throws Exception{
        try{

            Object[] args = getConstructorArgumentValues(beanDefinition);
            if (null == args) {
                return beanDefinition.getBeanClass().newInstance();
            }else{
                return determinConstructor(beanDefinition,args).newInstance(args);
            }
        }catch (Exception e){
            throw new Exception("创建bean的实例异常,beanDefinition：" + beanDefinition + e.getMessage());
        }
    }

    public Object createInstanceByStaticFactoryMethod(BeanDefinition beanDefinition)throws Exception{

        Class<?> classType = beanDefinition.getBeanClass();
        Object[] args = getRealValues(beanDefinition.getConstructorArgumentValues());
        Method method = determinMethod(beanDefinition,args,null);
        return method.invoke(classType,args);
    }

    public Object createInstanceByFactoryMethod(BeanDefinition beanDefinition)throws Exception{

        Object factoryBean = doGetBean(beanDefinition.getFactoryBeanName());
        Object[] args = getRealValues(beanDefinition.getConstructorArgumentValues());
        Method method = determinMethod(beanDefinition, args,factoryBean.getClass());

        return method.invoke(factoryBean,args);
    }

    public Object[] getRealValues(List<?> defs)throws Exception{

        if(CollectionUtils.isEmpty(defs)){
            return null;
        }

        Object[] realValues = new Object[defs.size()];

        Object realValue = null;
        int i = 0;
        for(Object rv : defs){

            realValue = resolvePropertyValue(rv);
            realValues[i++] = realValue;
        }

        return realValues;
    }

    private Object[] getConstructorArgumentValues(BeanDefinition bd) throws Exception {

        return this.getRealValues(bd.getConstructorArgumentValues());

    }

    public void doInitMethod(BeanDefinition beanDefinition,Object instance) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String initMethod = beanDefinition.getInitMethodName();
        if(StringUtils.isNotBlank(initMethod)){
            Method method = instance.getClass().getMethod(initMethod, null);
            method.invoke(instance,null);
        }
    }

    public Constructor<?> determinConstructor(BeanDefinition beanDefinition,Object[] args)throws Exception{

        Constructor ctr = null;

        if(null == args){
            return beanDefinition.getBeanClass().getConstructor();
        }

        ctr = beanDefinition.getConstructor();
        if(null != ctr){
            return ctr;
        }

        Class[] paramTypes = new Class[args.length];
        for (int i = 0, len = args.length; i < len; i++) {
            paramTypes[i] = args[i].getClass();
        }

        try{
            ctr = beanDefinition.getBeanClass().getConstructor(paramTypes);
        }catch (Exception e){

        }

        if(null == ctr){
            Constructor<?>[] constructors = beanDefinition.getBeanClass().getConstructors();
            outer: for(Constructor constructor : constructors){

                Class[] parameterTypes = constructor.getParameterTypes();
                if(parameterTypes.length == args.length){
                    for (int j = 0,leng = parameterTypes.length; j < leng; j++) {

                        if(!parameterTypes[j].isAssignableFrom(args[j].getClass())){
                            continue outer;
                        }
                    }
                    ctr = constructor;
                    break outer;
                }
            }
        }

        if(null != ctr){

            beanDefinition.setConstructor(ctr);
            return ctr;
        }else{
            throw new Exception("找不到构造器");
        }

    }

    public Method determinMethod(BeanDefinition beanDefinition,Object[] args,Class<?> classType)throws Exception{

        if(null == classType){
            classType = beanDefinition.getBeanClass();
        }

        Method method = null;

        String methodName = beanDefinition.getFactoryMethodName();
        if(null == args){
            return classType.getMethod(methodName);
        }

        method = beanDefinition.getFactoryMethod();
        if(null != method){
            return method;
        }

        Class[] paramTypes = new Class[args.length];
        for (int i = 0, len = args.length; i < len; i++) {
            paramTypes[i] = args[i].getClass();
        }

        try{
            method = classType.getMethod(methodName,paramTypes);
        }catch (Exception e){

        }

        if(null == method){
            Method[] methods = classType.getMethods();

            outer: for(Method me : methods){
                if(!me.getName().equals(methodName)){
                    continue ;
                }else{
                    Class<?>[] parameterTypes = me.getParameterTypes();
                    if(parameterTypes.length == args.length){
                        for (int j = 0,leng = parameterTypes.length; j < leng; j++) {

                            if(!parameterTypes[j].isAssignableFrom(args[j].getClass())){
                                continue outer;
                            }
                        }
                        method = me;
                        break outer;
                    }
                }
            }
        }

        if(null != method){
            beanDefinition.setFactoryMethod(method);
            return method;
        }else{
            throw new Exception("找不到方法");
        }
    }


    public void setPropertyDIValues(BeanDefinition beanDefinition,Object intance)throws Exception{

        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues();
        if(!CollectionUtils.isEmpty(propertyValues)){

            for(PropertyValue propertyValue : propertyValues){
                if(StringUtils.isEmpty(propertyValue.getName())){
                    continue;
                }

                Class<?> clazz = intance.getClass();
                Field field = clazz.getDeclaredField(propertyValue.getName());

                field.setAccessible(true);

                Object realValue = resolvePropertyValue(propertyValue.getValue());

                field.set(intance,realValue);
            }
        }

    }

    public Object resolvePropertyValue(Object value)throws Exception{

        Object realValue = null;

        if(null != value){
            if(value instanceof BeanRefernerce){
                realValue = getBean(((BeanRefernerce) value).getBeanName());
            } else if (value instanceof Object[]) {

            } else if (value instanceof Collection) {

            } else if (value instanceof Properties) {

            } else if (value instanceof Map) {

            } else {
                realValue = value;
            }
        }

        return realValue;
    }

    public Object applyPostProcessBeforeInitialization(String beanName,Object instance){

        for(BeanPostProcessor beanPostProcessor : beanPostProcessorList){
            instance = beanPostProcessor.postProcessBeforeInitialization(beanName,instance);
        }

        return instance;

    }


    public Object applyPostProcessAfterInitialization(String beanName,Object instance){

        for(BeanPostProcessor beanPostProcessor : beanPostProcessorList){
            instance = beanPostProcessor.postProcessAfterInitialization(beanName,instance);
        }

        return instance;
    }

    @Override
    public void close() throws IOException {
        //执行单例实例的销毁方法

        for(Map.Entry<String,BeanDefinition> entry : beanDefinitionMap.entrySet()){
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();

            if(beanDefinition.isSingleton() && !StringUtils.isEmpty(beanDefinition.getDestroyMethodName())){

                Object instance = beanMap.get(beanName);
                try {
                    Method method = instance.getClass().getMethod(beanDefinition.getDestroyMethodName(),null);

                    method.invoke(instance,null);

                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
