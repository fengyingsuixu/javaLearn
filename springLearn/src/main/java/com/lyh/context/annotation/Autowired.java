package com.lyh.context.annotation;

import java.lang.annotation.*;

/**
 * Created by lvyanghui
 * 2019/2/14 17:02
 */
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    String name();
}
