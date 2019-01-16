package com.lyh.aop;

import com.lyh.aop.advisor.Advisor;
import com.lyh.beans.BeanFactory;

import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:45
 */
public interface AopProxyFactory {
    AopProxy createAopProxy(String beanName, Object bean, List<Advisor> advisors, BeanFactory beanFactory);

    static AopProxyFactory getDefaultAopProxyFactory(){
        return new DefaultAopProxyFactory();
    }

}
