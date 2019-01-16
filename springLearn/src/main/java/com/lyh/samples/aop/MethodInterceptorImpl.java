package com.lyh.samples.aop;

import com.lyh.aop.advice.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 22:13
 */
public class MethodInterceptorImpl implements MethodInterceptor {
    @Override
    public Object invoke(Method method, Object[] args, Object target) throws Exception{

        System.out.println("环绕增强调用 aroundMethod 方法.......前");

        Object result = method.invoke(target,args);

        System.out.println("环绕增强调用 aroundMethod 方法.......后");
        return result;
    }

}
