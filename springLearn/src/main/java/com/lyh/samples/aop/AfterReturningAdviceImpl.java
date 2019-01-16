package com.lyh.samples.aop;

import com.lyh.aop.advice.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 22:12
 */
public class AfterReturningAdviceImpl implements AfterReturningAdvice {
    @Override
    public void afterReturing(Object returnValue, Method method, Object[] args, Object target) {
        System.out.println("后置增强调用 afterMethod 方法.......");
    }
}
