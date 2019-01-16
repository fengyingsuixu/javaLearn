package com.lyh.aop;

import com.lyh.aop.advisor.Advisor;
import com.lyh.beans.BeanFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:49
 */
public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {
    private String beanName;
    private Object bean;
    private List<Advisor> advisors;
    private BeanFactory beanFactory;

    public JdkDynamicAopProxy(String beanName, Object bean, List<Advisor> advisors, BeanFactory beanFactory) {
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
        return Proxy.newProxyInstance(classLoader,bean.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return AopProxyUtils.doInvokeAdvice(proxy,bean,method,args,advisors,beanFactory);
    }
}
