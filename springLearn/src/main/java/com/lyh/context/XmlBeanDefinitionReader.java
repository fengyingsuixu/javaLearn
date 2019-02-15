package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/14 18:00
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws IOException {

        InputStream inputStream = resource.getInputStream();

        parseXml(inputStream);
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws IOException {

        if(null != resources && resources.length > 0){
            for(Resource resource : resources){
                loadBeanDefinitions(resource);
            }
        }
    }

    public void parseXml(InputStream inputStream){

        //解析xml 创建bean对象 注册bean对象
    }
}
