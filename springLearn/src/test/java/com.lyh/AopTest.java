package com.lyh;

import com.lyh.aop.AdvisorAutoProxyCreator;
import com.lyh.aop.advisor.AspectJPointCutAdvisor;
import com.lyh.beans.GenericBeanDefinition;
import com.lyh.beans.PreBuildBeanFactory;
import com.lyh.samples.AopBean;
import com.lyh.samples.aop.AfterReturningAdviceImpl;
import com.lyh.samples.aop.MethodBeforeAdviceImpl;
import com.lyh.samples.aop.MethodInterceptorImpl;
import org.junit.Test;

/**
 * Created by lvyanghui
 * 2019/1/16 22:19
 */
public class AopTest {
    static PreBuildBeanFactory beanFactory = new PreBuildBeanFactory();

    @Test
    public void aopTest()throws Exception{

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(AopBean.class);

        beanFactory.registerBeanDefinition("aop",beanDefinition);

        beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MethodBeforeAdviceImpl.class);
        beanFactory.registerBeanDefinition("beforeAdvice",beanDefinition);

        beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(AfterReturningAdviceImpl.class);
        beanFactory.registerBeanDefinition("afterAdvice",beanDefinition);

        beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MethodInterceptorImpl.class);
        beanFactory.registerBeanDefinition("aroundAdvice",beanDefinition);

        AdvisorAutoProxyCreator creater = new AdvisorAutoProxyCreator();
        beanFactory.registryBeanPostProcessor(creater);

        creater.registryAdvisor(new AspectJPointCutAdvisor("execution(* com.lyh.samples.AopBean.method*(..))","afterAdvice"));
        creater.registryAdvisor(new AspectJPointCutAdvisor("execution(* com.lyh.samples.AopBean.method*(..))","aroundAdvice"));
        creater.registryAdvisor(new AspectJPointCutAdvisor("execution(* com.lyh.samples.AopBean.method*(..))","beforeAdvice"));

        beanFactory.preInstantiateSingletons();

        AopBean aopBean = (AopBean)beanFactory.getBean("aop");

        aopBean.methodTwo();
        aopBean.methodOne(1,"jjj");

    }


}
