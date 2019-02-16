package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/2/14 17:55
 */
public class XmlApplicationContext extends AbstractApplicationContext{

    private List<Resource> resources;
    private BeanDefinitionReader reader;

    public XmlApplicationContext(String ...locations)throws Exception{
        load(locations);
        reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        reader.loadBeanDefinitions(resources.toArray(new Resource[resources.size()]));
    }

    @Override
    public Resource getResource(String location) throws IOException {

        Resource resource = null;
        if(location.startsWith(Resource.CLASS_PATH_PREFIX)){
            resource = new ClassPathResource(location);
        }else if(location.startsWith(Resource.FILE_SYSTEM_PREFIX)){
            resource = new FileSystemResource(location);
        }else{
            resource = new UrlResource(location);
        }
        return resource;
    }

    public void load(String ...locations)throws IOException{

        if(null == resources){
            resources = new ArrayList<>();
        }
        if(null != locations && locations.length > 0){
            for(String location : locations){
                Resource resource = getResource(location);
                resources.add(resource);
            }
        }
    }
}
