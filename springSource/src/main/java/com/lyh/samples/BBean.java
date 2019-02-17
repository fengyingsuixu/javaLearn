package com.lyh.samples;

import org.springframework.stereotype.Component;

/**
 * Created by lvyanghui
 * 2019/1/16 22:16
 */
@Component
public class BBean {
    public void initMethod(){

        System.out.println("BBean 执行初始化方法.....");
    }

    public void methodB(){
        System.out.println("BBean 执行methodB.......");
    }

    public void destoryB(){
        System.out.println("BBean 执行destoryB.......");
    }

}
