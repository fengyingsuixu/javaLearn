package com.lyh.aop;

import com.lyh.aop.advisor.Advisor;
import com.lyh.aop.advisor.AdvisorRegistry;
import com.lyh.aop.advisor.PointCutAdvisor;
import com.lyh.aop.pointcut.Pointcut;
import com.lyh.beans.BeanFactory;
import com.lyh.beans.BeanFactoryAware;
import com.lyh.beans.BeanPostProcessor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lvyanghui
 * 2019/1/16 21:40
 */
public class AdvisorAutoProxyCreator implements AdvisorRegistry,BeanPostProcessor,BeanFactoryAware {
    private List<Advisor> advisors = new ArrayList<Advisor>();

    private BeanFactory beanFactory;

    @Override
    public void registryAdvisor(Advisor advisor) {
        advisors.add(advisor);
    }

    @Override
    public List<Advisor> getAdvisors() {
        return advisors;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {

        List<Advisor> matchsAdvisors = getMatchsAdvisor(beanName,bean);

        if(CollectionUtils.isNotEmpty(matchsAdvisors)){
            bean = createProxy(beanName, bean, matchsAdvisors);
        }
        return bean;
    }

    public List<Advisor> getMatchsAdvisor(String beanName, Object bean){

        List<Advisor> matchsAdvisors = new ArrayList<Advisor>();

        Class beanClass = bean.getClass();
        List<Method> allMethods = getAllMethodForClass(beanClass);
        for(Advisor advisor : advisors){

            if(advisor instanceof PointCutAdvisor){
                if(isPointcutMatchBean((PointCutAdvisor)advisor,beanClass,allMethods)){
                    matchsAdvisors.add(advisor);
                }
            }


        }
        return matchsAdvisors;
    }

    public List<Method> getAllMethodForClass(Class beanClass){

        List<Method> allMethods = new ArrayList<>();

        Set<Class<?>> classes = ClassUtils.getAllInterfacesForClassAsSet(beanClass);
        classes.add(beanClass);

        for(Class clazz : classes){

            Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(clazz);

            for(Method method : allDeclaredMethods){
                allMethods.add(method);
            }
        }
        return allMethods;
    }

    public boolean isPointcutMatchBean(PointCutAdvisor pa, Class clazz, List<Method> allMethods){

        Pointcut pointcut = pa.getPointcut();


        if(!pointcut.matchsClass(clazz)){
            return false;
        }

        for(Method method : allMethods){
            if(pointcut.matchsMethod(method,clazz)){
                return true;
            }
        }

        return false;
    }

    public Object createProxy(String beanName, Object bean, List<Advisor> matchsAdvisors){

        AopProxy aopProxy = AopProxyFactory.getDefaultAopProxyFactory().createAopProxy(beanName, bean, matchsAdvisors, beanFactory);
        return aopProxy.getProxy();
    }

}
