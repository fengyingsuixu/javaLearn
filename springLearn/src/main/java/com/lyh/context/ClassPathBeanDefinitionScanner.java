package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/2/14 17:57
 */
public class ClassPathBeanDefinitionScanner {


    private BeanDefinitionRegistry registry;
    private BeanDefinitionReader reader;

    private PathMatcher pathMatcher = new AntPathMatcher();
    private String resourcePattern = "**/*.class";

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.reader = new AnnotationBeanDefinitionReader(registry);
    }

    public void scan(String ...basePackages)throws Exception{

        if(null != basePackages && basePackages.length > 0){

            for(String basePackage : basePackages){

                List<Resource> resources = doScan(basePackage);

                this.reader.loadBeanDefinitions(resources.toArray(new Resource[resources.size()]));
            }
        }
    }


    public List<Resource> doScan(String basePackage)throws Exception{

        String pathPattern = StringUtils.replace(basePackage,".","/") + "/" + resourcePattern;
        if('/' != pathPattern.charAt(0)){
            pathPattern = "/" + pathPattern;
        }

        String rootPath = determinRootDir(pathPattern);

        String fullPattern = this.getClass().getResource(rootPath).toURI() + resourcePattern;

        File rootDir = new File(this.getClass().getResource(rootPath).toURI());
        List<Resource> resources = new ArrayList<>();
        doRetrieveMatchingFiles(fullPattern,rootDir,resources);

        return resources;
    }

    public String determinRootDir(String path){

        String rootPath = path;

        int rootDirEnd = path.indexOf("*");
        if(rootDirEnd != -1){
            rootPath = path.substring(0,rootDirEnd);
        }
        return rootPath;
    }

    public void doRetrieveMatchingFiles(String fullPattern,File rootDir,List<Resource> resources){

        File[] files = getFiles(rootDir);

        for(File file : files){
            String currPath = Resource.FILE_SYSTEM_PREFIX + file.toURI().getPath();
            if(file.isDirectory() && getPathMatcher().matchStart(fullPattern,currPath)){
                doRetrieveMatchingFiles(fullPattern,file,resources);
            }

            if(getPathMatcher().match(fullPattern,currPath)){
                resources.add(new FileSystemResource(file));
            }
        }
    }

    private File[] getFiles(File rootDir){
        File[] files = rootDir.listFiles();

        if(null == files){
            files = new File[0];
        }
        return  files;
    }


    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public BeanDefinitionReader getReader() {
        return reader;
    }

    public void setReader(BeanDefinitionReader reader) {
        this.reader = reader;
    }

    public PathMatcher getPathMatcher() {
        return pathMatcher;
    }

    public void setPathMatcher(PathMatcher pathMatcher) {
        this.pathMatcher = pathMatcher;
    }

    public String getResourcePattern() {
        return resourcePattern;
    }

    public void setResourcePattern(String resourcePattern) {
        this.resourcePattern = resourcePattern;
    }
}
