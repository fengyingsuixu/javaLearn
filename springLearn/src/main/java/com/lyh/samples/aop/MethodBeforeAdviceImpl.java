package com.lyh.samples.aop;

import com.lyh.aop.advice.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 22:13
 */
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {
    @Override
    public void beforeMethod(Method method, Object[] args, Object target) {
        System.out.println("前置增强调用beforeMethod方法.......");
    }
}
