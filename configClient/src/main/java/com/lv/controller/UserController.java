package com.lv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvyanghui
 * 2019/3/6 22:12
 */

@RestController
//@RefreshScope
public class UserController {

    @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;
    @Value("${address}")
    private String address;

    @RequestMapping("/user")
    private String getUser(){
        return "name:" + name + "age:" + age + "address:" + address;
    }
}
