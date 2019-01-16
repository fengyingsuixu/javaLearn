package com.lyh.beans;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lvyanghui on 2018/12/16.
 */
public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    Class<?> getBeanClass();

    String getScope();

    boolean isSingleton();
    boolean isPrototype();

    String getFactoryBeanName();
    String getFactoryMethodName();

    String getInitMethodName();

    String getDestroyMethodName();

    List<?> getConstructorArgumentValues();

    List<PropertyValue> getPropertyValues();

    public Object[] getConstructorArgumentRealValues();

    public void setConstructorArgumentRealValues(Object[] values);

    public Constructor getConstructor();

    public void setConstructor(Constructor constructor);

    public Method getFactoryMethod();

    public void setFactoryMethod(Method factoryMethod);

    default boolean validate(){

        if(this.getBeanClass() == null){
            if(StringUtils.isEmpty(this.getFactoryBeanName()) || StringUtils.isEmpty(this.getFactoryMethodName())){
                return false;
            }
        }else{
            if(!StringUtils.isEmpty(this.getFactoryBeanName())){
                return false;
            }
        }
        return true;
    }

 }
