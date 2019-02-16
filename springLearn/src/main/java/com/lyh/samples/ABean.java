package com.lyh.samples;

import com.lyh.context.annotation.Component;

/**
 * Created by lvyanghui
 * 2019/1/16 22:16
 */
@Component
public class ABean {
    public void initMethod(){

        System.out.println("ABean 执行初始化方法.....");
    }

    public void methodA(){
        System.out.println("ABean 执行methodA.......");
    }

    public void destoryA(){
        System.out.println("ABean 执行destoryA.......");
    }

}
