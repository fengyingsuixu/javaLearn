package com.lyh.aop.advice;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 21:31
 */
public interface MethodInterceptor extends Advice{
    Object invoke(Method method, Object[] args, Object target) throws Exception;
}
