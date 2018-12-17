package com.lyh.beans;

/**
 * Created by lvyanghui on 2018/12/17.
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;
}
