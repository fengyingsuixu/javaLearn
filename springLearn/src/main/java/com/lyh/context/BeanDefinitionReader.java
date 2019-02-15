package com.lyh.context;

import java.io.IOException;

/**
 * Created by lvyanghui
 * 2019/2/14 17:58
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(Resource resource) throws IOException;

    void loadBeanDefinitions(Resource ...resources) throws IOException;
}
