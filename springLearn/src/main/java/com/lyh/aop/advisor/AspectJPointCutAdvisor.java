package com.lyh.aop.advisor;

import com.lyh.aop.pointcut.AspectJExpressionPointcut;
import com.lyh.aop.pointcut.Pointcut;

/**
 * Created by lvyanghui
 * 2019/1/16 21:33
 */
public class AspectJPointCutAdvisor implements Advisor,PointCutAdvisor {

    private String expression;

    private String adviceBeanName;

    private Pointcut pointcut;

    public AspectJPointCutAdvisor(String expression, String adviceBeanName) {
        this.expression = expression;
        this.adviceBeanName = adviceBeanName;
        pointcut = new AspectJExpressionPointcut(expression);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public String getAdviceBeanName() {
        return adviceBeanName;
    }

    @Override
    public String getExpression() {
        return expression;
    }
}
