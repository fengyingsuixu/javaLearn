package com.lyh.aop;

import com.lyh.aop.advice.Advice;
import com.lyh.aop.advisor.Advisor;
import com.lyh.aop.advisor.PointCutAdvisor;
import com.lyh.beans.BeanFactory;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:46
 */
public class AopProxyUtils {
    public static Object doInvokeAdvice(Object proxy, Object target, Method method, Object[] args, List<Advisor> advisors, BeanFactory beanFactory)throws Exception{

        List<Advice> advices = getMatchAdvices(advisors,method,target,beanFactory);

        if(CollectionUtils.isEmpty(advices)){
            return method.invoke(target,args);
        }else{
            AopAdviceChainInvocation chain = new AopAdviceChainInvocation(proxy,target,method,args,advices);
            return chain.doAdvice();
        }
    }

    public static List<Advice> getMatchAdvices(List<Advisor> advisors,Method method,Object target,BeanFactory beanFactory)throws Exception{

        if(CollectionUtils.isEmpty(advisors)){

            return null;
        }

        List<Advice> advices = new ArrayList<>();

        for(Advisor advisor : advisors){

            if(advisor instanceof PointCutAdvisor){
                if(((PointCutAdvisor) advisor).getPointcut().matchsMethod(method,target.getClass())){

                    advices.add((Advice)beanFactory.getBean(advisor.getAdviceBeanName()));
                }
            }
        }

        return advices;
    }

}
