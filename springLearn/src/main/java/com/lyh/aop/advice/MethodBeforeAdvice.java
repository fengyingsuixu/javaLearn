package com.lyh.aop.advice;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 21:31
 */
public interface MethodBeforeAdvice extends Advice{
    void beforeMethod(Method method, Object[] args, Object target);

}
