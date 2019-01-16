package com.lyh.aop;

import com.lyh.aop.advice.Advice;
import com.lyh.aop.advice.AfterReturningAdvice;
import com.lyh.aop.advice.MethodBeforeAdvice;
import com.lyh.aop.advice.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:44
 */
public class AopAdviceChainInvocation {

    private Object proxy;
    private Object target;
    private Method method;
    private Object[] args;
    private List<Advice> advices;

    public AopAdviceChainInvocation(Object proxy, Object target, Method method, Object[] args, List<Advice> advices) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.args = args;
        this.advices = advices;
    }


    private int index = 0;
    public Object doAdvice()throws Exception{

        if(index == advices.size()){
            return method.invoke(target,args);
        }

        Advice advice = advices.get(index++);
        if(advice instanceof MethodBeforeAdvice){
            ((MethodBeforeAdvice) advice).beforeMethod(method,args,target);
        }else if(advice instanceof MethodInterceptor){
            Method doAdviceMethod = this.getClass().getMethod("doAdvice", null);
            return ((MethodInterceptor) advice).invoke(doAdviceMethod, null, this);
        }else if(advice instanceof AfterReturningAdvice){
            Object returnValue = doAdvice();
            ((AfterReturningAdvice) advice).afterReturing(returnValue, method, args, target);
            return returnValue;
        }

        return this.doAdvice();
    }

}
