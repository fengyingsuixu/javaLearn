package com.lyh.context.annotation;

import java.lang.annotation.*;

/**
 * Created by lvyanghui
 * 2019/2/14 17:04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Qualifier {

    String value();
}
