package com.lyh.remoteservice;

import com.lyh.hystrix.DisableHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lvyanghui
 * 2019/3/2 18:37
 */
@FeignClient(value = "serviceProvider",fallback = FeignFallback.class,configuration = DisableHystrix.class)
public interface FeignService {

    @GetMapping("/provider/hello")
    String feignHello(@RequestParam(value = "name") String name);
}
