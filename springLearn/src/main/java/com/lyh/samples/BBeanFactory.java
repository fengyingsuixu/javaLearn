package com.lyh.samples;

import com.lyh.samples.ABean;
import com.lyh.samples.BBean;

/**
 * Created by lvyanghui
 * 2019/1/16 22:17
 */
public class BBeanFactory {
    public static BBean getBeanByFactory(String name, ABean aBean){

        return new BBean();
    }

    public BBean getBeanByFactoryBean(String name, ABean aBean, String kk){

        return new BBean();
    }

}
