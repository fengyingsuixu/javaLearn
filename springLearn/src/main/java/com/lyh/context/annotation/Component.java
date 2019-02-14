package com.lyh.context.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

    String className();

    String scope() default SCOPE_SINGLETON;

    String factoryBeanName();

    String factoryMethodName();

    String initMethodName();

    String destroyMethodName();
}
