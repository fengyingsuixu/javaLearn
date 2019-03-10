package com.lyh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lvyanghui
 * 2019/3/2 17:54
 */
@RestController
@RequestMapping("/pvd")
public class HiController {

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam String name){
        return "hi " + name;
    }

    public String hiError(String name){
        return "hi" + name + " sorry,error";
    }
}
