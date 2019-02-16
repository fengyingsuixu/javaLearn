package com.lyh.context.annotation;

import java.lang.annotation.*;

/**
 * Created by lvyanghui
 * 2019/2/14 16:51
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String SCOPE_SINGLETON = "singleton";

    String className() default "";

    String scope() default SCOPE_SINGLETON;

    String factoryBeanName() default "";

    String factoryMethodName() default "";

    String initMethodName() default "";

    String destroyMethodName() default "";
}
