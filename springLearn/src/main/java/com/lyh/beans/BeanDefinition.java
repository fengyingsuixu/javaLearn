package com.lyh.beans;

/**
 * Created by lvyanghui on 2018/12/16.
 */
public interface BeanDefinition {

    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_SINGLETON = "singleton";


    Class<?> getBeanClass();

    String getScope();

    boolean isSingleton();

    boolean isPrototype();

    String getFactoryBeanName();

    String getFactoryMethodName();

    String getInitMethodName();

    String getDestoryMethodName();


    default boolean validate(){

        if(getBeanClass() == null){
            //if(StringUtils.isE)
        }
        return true;
    }
 }
