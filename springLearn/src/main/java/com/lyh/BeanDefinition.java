package com.lyh;

/**
 * Created by lvyanghui on 2018/12/16.
 */
public interface BeanDefinition {

    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_SINGLETON = "singleton";


    Class<?> getBeanClass();

    boolean isSingleton();


 }
