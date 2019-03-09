package com.lv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by lvyanghui
 * 2019/3/9 22:40
 */
@SpringBootApplication
@EnableTurbine
public class JarApp {

    public static void main(String[] args) {
        SpringApplication.run(JarApp.class,args);
    }
}
