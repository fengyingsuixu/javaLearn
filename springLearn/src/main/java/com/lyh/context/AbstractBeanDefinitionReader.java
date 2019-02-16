package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;

/**
 * Created by lvyanghui
 * 2019/2/14 22:02
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{


    protected BeanDefinitionRegistry registry;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }
}
