package com.lyh.context;

import java.io.File;

/**
 * Created by lvyanghui
 * 2019/2/14 16:48
 */
public interface Resource extends InputStreamResource{

    public static final String CLASS_PATH_PREFIX = "classpath:";
    public static final String FILE_SYSTEM_PREFIX = "file:";

    boolean exists();

    boolean isReadable();

    boolean isOpen();

    File getFile();
}
