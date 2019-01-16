package com.lyh.samples;

/**
 * Created by lvyanghui
 * 2019/1/16 22:16
 */
public class ABeanFactory {
    public static ABean getBeanByFactory(){

        return new ABean();
    }

    public ABean getBeanByFactoryBean(){

        return new ABean();
    }

}
