package com.lyh.context;

import java.io.IOException;

/**
 * Created by lvyanghui
 * 2019/2/14 18:01
 */
public class AnnotationnApplicationContext extends AbstractApplicationContext{

    private ClassPathBeanDefinitionScanner scanner;

    public AnnotationnApplicationContext(String ...basePackaes) {
        this.scanner = new ClassPathBeanDefinitionScanner();
        scanner.scan(basePackaes);
    }

    @Override
    public Resource getResource(String location) throws IOException {
        return null;
    }
}
