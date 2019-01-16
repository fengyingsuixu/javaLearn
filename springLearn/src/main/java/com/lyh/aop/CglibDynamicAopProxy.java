package com.lyh.aop;


import com.lyh.aop.advisor.Advisor;
import com.lyh.beans.BeanFactory;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:47
 */
public class CglibDynamicAopProxy implements AopProxy,MethodInterceptor {
    private static Enhancer enhancer = new Enhancer();

    private String beanName;
    private Object bean;
    private List<Advisor> advisors;
    private BeanFactory beanFactory;

    public CglibDynamicAopProxy(String beanName, Object bean, List<Advisor> advisors, BeanFactory beanFactory) {
        this.beanName = beanName;
        this.bean = bean;
        this.advisors = advisors;
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getProxy() {
        return getProxy(bean.getClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {

        enhancer.setSuperclass(bean.getClass());
        enhancer.setInterfaces(this.getClass().getInterfaces());
        enhancer.setCallback(this);

        return enhancer.create();
        /*Constructor constructor = null;
        try {
            constructor = bean.getClass().getConstructor();
        } catch (NoSuchMethodException e) {
        }
        if(null != constructor){
            return enhancer.create();
        }else{
            BeanDefinition beanDefinition = ((DefaultBeanFactory) beanFactory).getBeanDefinition(beanName);
            return enhancer.create(beanDefinition.getConstructor().getParameterTypes(),beanDefinition.getConstructorArgumentRealValues());
        }*/


    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return AopProxyUtils.doInvokeAdvice(proxy,bean,method,args,advisors,beanFactory);
    }


}
