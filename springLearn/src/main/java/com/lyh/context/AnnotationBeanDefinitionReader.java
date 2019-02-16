package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;
import com.lyh.beans.GenericBeanDefinition;
import com.lyh.context.annotation.Component;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;

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
        retriveAndRegistBeanDefinition(resource);
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws Exception{

        if(null != resources && resources.length > 0){
            for(Resource resource : resources){
                loadBeanDefinitions(resource);
            }
        }
    }

    private void retriveAndRegistBeanDefinition(Resource resource)throws Exception{

        if(null != resource && null != resource.getFile()){
            String className = getClassNameFromFile(resource.getFile());
            Class clazz = Class.forName(className);
            Annotation annotation = clazz.getAnnotation(Component.class);
            if(null != annotation){
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClass(clazz);
                String name = generateName(clazz);
                registry.registerBeanDefinition(name,beanDefinition);
            }
        }
    }

    private String getClassNameFromFile(File file) {
        String absPath = file.getAbsolutePath();
        String name = absPath.substring(absPath.lastIndexOf("classes") + 8, absPath.lastIndexOf(".class"));
        return StringUtils.replace(name, File.separator, ".");
    }

    private String generateName(Class clazz){
        String className = clazz.getSimpleName();
        String name = String.valueOf(className.charAt(0)).toLowerCase() + className.substring(1,className.length());
        return name;
    }
}
