package com.lyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lvyanghui
 * 2019/3/2 14:47
 */
@EnableEurekaServer
@SpringBootApplication
public class JarApp {

    public static void main(String[] args) {
        SpringApplication.run(JarApp.class,args);
    }
}
