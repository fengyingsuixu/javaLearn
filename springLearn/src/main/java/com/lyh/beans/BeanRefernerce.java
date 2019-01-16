package com.lyh.beans;

/**
 * Created by lvyanghui
 * 2019/1/16 22:03
 */
public class BeanRefernerce {
    private String beanName;

    public BeanRefernerce(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}
