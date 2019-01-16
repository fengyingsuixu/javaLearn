package com.lyh.beans;

/**
 * Created by lvyanghui
 * 2019/1/16 22:02
 */
public interface BeanPostProcessor {
    default Object postProcessBeforeInitialization(String beanName,Object bean){

        return bean;
    }

    default Object postProcessAfterInitialization(String beanName,Object bean){

        return bean;
    }

}
