package com.lyh.remoteservice;

import org.springframework.stereotype.Component;

/**
 * Created by lvyanghui
 * 2019/3/2 20:28
 */
@Component
public class FeignFallback implements FeignService{
    @Override
    public String feignHello(String name) {
        return "默认值hello world";
    }
}
