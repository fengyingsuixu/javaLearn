package com.lyh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvyanghui
 * 2019/2/24 17:20
 */
@RestController
@RequestMapping("/boot")
public class HelloController {

    @RequestMapping("/hello")
    public String bootMethod(){
        return "hello world!";
    }
}
