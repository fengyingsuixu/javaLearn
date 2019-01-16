package com.lyh.aop.advisor;

/**
 * Created by lvyanghui
 * 2019/1/16 21:32
 */
public interface Advisor {

    String getAdviceBeanName();

    String getExpression();
}
