package com.lyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by lvyanghui
 * 2019/2/24 17:51
 */
@SpringBootApplication
public class WarApp extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(WarApp.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarApp.class);
    }
}
