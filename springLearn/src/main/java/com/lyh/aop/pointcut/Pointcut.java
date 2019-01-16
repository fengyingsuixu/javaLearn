package com.lyh.aop.pointcut;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 21:36
 */
public interface Pointcut {
    boolean matchsClass(Class<?> targetClass);

    boolean matchsMethod(Method method, Class<?> targetClass);
}
