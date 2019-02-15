package com.lyh.context;

import java.util.List;

/**
 * Created by lvyanghui
 * 2019/2/14 17:57
 */
public class ClassPathBeanDefinitionScanner {

    private List<Resource> resources;

    public void scan(String ...basePackages){

        if(null != basePackages && basePackages.length > 0){

            for(String basePackage : basePackages){
                doScan(basePackage);
            }
        }
    }


    public void doScan(String basePackage){



    }

}
