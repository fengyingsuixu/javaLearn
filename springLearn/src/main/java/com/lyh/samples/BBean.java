package com.lyh.samples;

import com.lyh.samples.ABean;

/**
 * Created by lvyanghui
 * 2019/1/16 22:17
 */
public class BBean {
    private String name;

    private ABean aBean;

    public BBean() {
    }

    public BBean(String name) {
        this.name = name;
    }

    public BBean(String name, ABean aBean) {
        this.name = name;
        this.aBean = aBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ABean getaBean() {
        return aBean;
    }

    public void setaBean(ABean aBean) {
        this.aBean = aBean;
    }


}
