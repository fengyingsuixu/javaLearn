package com.lyh.context;

import java.io.File;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/14 16:48
 */
public interface Resource extends InputStreamResource{


    boolean exists();

    boolean isReadable();

    boolean isOpen();

    File getFile();
}
