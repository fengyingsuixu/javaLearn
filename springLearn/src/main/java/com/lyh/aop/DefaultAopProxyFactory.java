package com.lyh.aop;

import com.lyh.aop.advisor.Advisor;
import com.lyh.beans.BeanFactory;

import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:48
 */
public class DefaultAopProxyFactory implements AopProxyFactory{

    @Override
    public AopProxy createAopProxy(String beanName, Object bean, List<Advisor> advisors, BeanFactory beanFactory) {

        if(shouldUseJDKDynamicProxy(beanName,bean)){
            return new JdkDynamicAopProxy(beanName,bean,advisors,beanFactory);
        }else{
            return new CglibDynamicAopProxy(beanName,bean,advisors,beanFactory);
        }

    }

    public boolean shouldUseJDKDynamicProxy(String beanName, Object bean) {

        return false;

    }
}
