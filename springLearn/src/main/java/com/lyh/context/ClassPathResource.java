package com.lyh.context;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/14 19:43
 */
public class ClassPathResource implements Resource{

    private String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        InputStream inputStream = null;
        if(StringUtils.isNotEmpty(path)){
            if(path.startsWith(CLASS_PATH_PREFIX)){
                String realPath = "/" + path.substring(CLASS_PATH_PREFIX.length());
                inputStream = this.getClass().getResourceAsStream(realPath);
            }
        }
        return inputStream;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public File getFile() {
        return null;
    }
}
