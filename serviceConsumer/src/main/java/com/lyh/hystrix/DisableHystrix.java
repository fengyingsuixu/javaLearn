package com.lyh.hystrix;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by lvyanghui
 * 2019/3/2 21:08
 */
@Configuration
public class DisableHystrix {
    //不启用断路器
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();

    }
}
