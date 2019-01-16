package com.lyh.samples;

/**
 * Created by lvyanghui
 * 2019/1/16 22:18
 */
public class EBean {
    private String name;

    private int age;

    private ABean aBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ABean getaBean() {
        return aBean;
    }

    public void setaBean(ABean aBean) {
        this.aBean = aBean;
    }

}
