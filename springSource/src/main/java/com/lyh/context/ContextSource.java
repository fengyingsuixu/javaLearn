package com.lyh.context;

import com.lyh.samples.BBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lvyanghui
 * 2019/2/17 13:47
 */
public class ContextSource {

    public static void main(String[] args) {

        //xml配置方式
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ABean aBean = (ABean) context.getBean("aBean");
        aBean.methodA();*/

        //注解方式
        ApplicationContext context = new AnnotationConfigApplicationContext("com.lyh.samples");
        BBean bBean = (BBean) context.getBean("BBean");
        bBean.methodB();
    }
}
