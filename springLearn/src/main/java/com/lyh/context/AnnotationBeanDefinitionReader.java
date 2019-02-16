package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;

import java.io.File;

/**
 * Created by lvyanghui
 * 2019/2/14 18:01
 */
public class AnnotationBeanDefinitionReader extends AbstractBeanDefinitionReader{


    public AnnotationBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }


    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception{
        File file = resource.getFile();

        String name = file.getName();
        try {
            Class clazz = Class.forName(name);
            
        } catch (ClassNotFoundException e) {

        }

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws Exception{

        if(null != resources && resources.length > 0){
            for(Resource resource : resources){
                loadBeanDefinitions(resource);
            }
        }
    }
}
