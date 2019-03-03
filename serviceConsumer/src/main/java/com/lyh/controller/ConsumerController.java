package com.lyh.controller;

import com.lyh.remoteservice.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lvyanghui
 * 2019/3/2 18:25
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    FeignService feignService;

    @GetMapping("/client")
    public String clientName(@RequestParam String name){

        ServiceInstance instance = loadBalancerClient.choose("serviceProvider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/provider/hello?name=" + name;
        System.out.println(url);
        return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/feign/{name}")
    public String feignName(@PathVariable("name") String name){

        return feignService.feignHello(name);
    }
}
