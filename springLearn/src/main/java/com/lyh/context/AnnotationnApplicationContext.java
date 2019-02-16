package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;

import java.io.IOException;

/**
 * Created by lvyanghui
 * 2019/2/14 18:01
 */
public class AnnotationnApplicationContext extends AbstractApplicationContext{

    private ClassPathBeanDefinitionScanner scanner;

    public AnnotationnApplicationContext(String ...basePackaes) throws Exception{
        this.scanner = new ClassPathBeanDefinitionScanner((BeanDefinitionRegistry)beanFactory);
        scanner.scan(basePackaes);
    }

    @Override
    public Resource getResource(String location) throws IOException {
        return null;
    }
}
