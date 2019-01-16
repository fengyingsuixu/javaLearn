package com.lyh.aop;

/**
 * Created by lvyanghui
 * 2019/1/16 21:45
 */
public interface AopProxy {
    Object getProxy();

    Object getProxy(ClassLoader classLoader);

}
