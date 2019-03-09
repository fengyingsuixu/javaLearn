package com.lyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lvyanghui
 * 2019/3/9 18:10
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String callhome(){
        return restTemplate.getForObject("http://localhost:9600/track/home",String.class);
    }

    @RequestMapping("/info")
    public String info(){
        return "service link";
    }
}
