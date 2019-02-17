package com.lyh.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvyanghui
 * 2019/2/17 13:47
 */
public class ContextSource {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("");

    }
}
