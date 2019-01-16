package com.lyh.aop.advice;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 21:27
 */
public interface AfterReturningAdvice extends Advice{
    void afterReturing(Object returnValue, Method method, Object[] args, Object target);
}
