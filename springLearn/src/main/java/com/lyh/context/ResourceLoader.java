package com.lyh.context;

import java.util.Set;

/**
 * Created by lvyanghui
 * 2019/2/14 17:22
 */
public interface ResourceLoader {
    Set<Resource> load(String ...locations);
}
