package com.lyh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvyanghui
 * 2019/3/2 17:54
 */
@RestController
@RequestMapping("/provider")
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "hello " + name;
    }
}
