package com.lyh.hystrix;

/**
 * Created by lvyanghui
 * 2019/3/2 20:17
 */
public class HystrixTest{

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                HystrixHello helloHystrix = new HystrixHello();
                helloHystrix.execute();
            }).start();

        }
    }

}
