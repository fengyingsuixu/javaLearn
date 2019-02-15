package com.lyh.context;

import java.io.IOException;

/**
 * Created by lvyanghui
 * 2019/2/14 17:22
 */
public interface ResourceLoader {
    Resource getResource(String location) throws IOException;
}
