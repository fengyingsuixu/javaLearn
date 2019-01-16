package com.lyh.beans;

/**
 * Created by lvyanghui on 2018/12/17.
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName,BeanDefinition beanDefinition)throws BeanDefinitionRegistryException;

    BeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);
}
