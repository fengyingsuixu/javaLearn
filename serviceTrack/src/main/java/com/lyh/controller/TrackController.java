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
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String home(){
        return "service track";
    }

    @RequestMapping("/info")
    public String callinfo(){
        return restTemplate.getForObject("http://localhost:9500/link/info",String.class);
    }
}
