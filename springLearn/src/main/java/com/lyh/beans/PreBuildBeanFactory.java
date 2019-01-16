package com.lyh.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 22:05
 */
public class PreBuildBeanFactory extends DefaultBeanFactory{
    private List<String> beanNames = new ArrayList<>();
    @Override
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition) throws BeanDefinitionRegistryException{

        super.registerBeanDefinition(beanName,beanDefinition);
        synchronized (beanNames){
            beanNames.add(beanName);
        }
    }

    public void preInstantiateSingletons()throws Exception{
        synchronized (beanNames){
            for(String beanName : beanNames){
                BeanDefinition beanDefinition = getBeanDefinition(beanName);
                if(beanDefinition.isSingleton()){
                    doGetBean(beanName);
                }
            }
        }


    }
}
