package com.lyh.context;

import java.util.Set;

/**
 * Created by lvyanghui
 * 2019/2/14 18:01
 */
public class AnnotationnApplicationContext extends AbstractApplicationContext{

    private ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner();

    @Override
    public Set<Resource> load(String... locations) {
        return null;
    }
}
