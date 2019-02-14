package com.lyh.context;

import com.lyh.beans.BeanFactory;
import com.lyh.beans.BeanPostProcessor;
import com.lyh.beans.DefaultBeanFactory;

/**
 * Created by lvyanghui
 * 2019/2/14 17:47
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected BeanFactory beanFactory;

    public AbstractApplicationContext() {
        beanFactory = new DefaultBeanFactory();
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }

    @Override
    public void registryBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanFactory.registryBeanPostProcessor(beanPostProcessor);
    }
}
