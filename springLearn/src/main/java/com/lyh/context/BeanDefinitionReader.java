package com.lyh.context;

/**
 * Created by lvyanghui
 * 2019/2/14 17:58
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(Resource resource) throws Exception;

    void loadBeanDefinitions(Resource ...resources) throws Exception;
}
