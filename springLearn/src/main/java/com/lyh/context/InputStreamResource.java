package com.lyh.context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/14 16:47
 */
public interface InputStreamResource {
    InputStream getInputStream() throws IOException;
}
