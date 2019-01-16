package com.lyh.aop.pointcut;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;

/**
 * Created by lvyanghui
 * 2019/1/16 21:36
 */
public class AspectJExpressionPointcut implements Pointcut{
    private PointcutParser parser = PointcutParser.getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();

    private String expression;

    private PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        this.expression = expression;
        pointcutExpression = parser.parsePointcutExpression(expression);
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public PointcutExpression getPointcutExpression() {
        return pointcutExpression;
    }

    public void setPointcutExpression(PointcutExpression pointcutExpression) {
        this.pointcutExpression = pointcutExpression;
    }

    @Override
    public boolean matchsClass(Class<?> targetClass) {
        return pointcutExpression.couldMatchJoinPointsInType(targetClass);
    }

    @Override
    public boolean matchsMethod(Method method, Class<?> targetClass) {

        ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);
        return shadowMatch.alwaysMatches();
    }
}
