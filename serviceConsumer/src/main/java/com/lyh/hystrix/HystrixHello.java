package com.lyh.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * Created by lvyanghui
 * 2019/3/2 20:17
 */
public class HystrixHello extends HystrixCommand<String>{

    public HystrixHello() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("first"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withQueueSizeRejectionThreshold(10))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationSemaphoreMaxConcurrentRequests(10))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withFallbackIsolationSemaphoreMaxConcurrentRequests(50))
        );
    }

    @Override
    protected String run() throws Exception {
        //Thread.sleep(10000);
        System.out.println("running...");
        // System.out.println(1 / 0);
        return "running...";
    }

    @Override
    protected String getFallback() {
        System.out.println("error running...");
        return "error running...";
    }


}
