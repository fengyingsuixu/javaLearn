package com.lyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by lvyanghui
 * 2019/3/2 17:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JarApp {

    public static void main(String[] args) {
        SpringApplication.run(JarApp.class,args);
    }
}
