package com.lyh.aop.advisor;

import com.lyh.aop.pointcut.Pointcut;

/**
 * Created by lvyanghui
 * 2019/1/16 21:34
 */
public interface PointCutAdvisor extends Advisor {

    Pointcut getPointcut();
}
