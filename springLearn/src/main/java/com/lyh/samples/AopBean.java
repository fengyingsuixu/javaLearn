package com.lyh.samples;

/**
 * Created by lvyanghui
 * 2019/1/16 22:16
 */
public class AopBean {
    public String methodOne(int i, String name){

        System.out.println("调用methodOne......" + i + name);

        return name;
    }


    public void methodTwo(){
        System.out.println("调用 methodTwo......");
    }

}
