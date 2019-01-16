package com.lyh.beans;

/**
 * Created by lvyanghui
 * 2019/1/16 22:01
 */
public class BeanDefinitionRegistryException extends Exception{
    public BeanDefinitionRegistryException(){
        super();
    }

    public BeanDefinitionRegistryException(Throwable cause){
        super(cause);
    }

    public BeanDefinitionRegistryException(String message){
        super(message);
    }

    public BeanDefinitionRegistryException(String message,Throwable cause){
        super(message,cause);
    }

}
