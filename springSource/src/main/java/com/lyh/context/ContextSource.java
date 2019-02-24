package com.lyh.context;

import com.lyh.samples.ABean;
import com.lyh.samples.BBean;
import com.lyh.samples.CBean;
import com.lyh.samples.DBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lvyanghui
 * 2019/2/17 13:47
 */
public class ContextSource {

    public static void main(String[] args) {

        //xml配置方式
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ABean aBean = (ABean) xmlContext.getBean("aBean");
        aBean.methodA();

        //注解方式
        ApplicationContext annoContext = new AnnotationConfigApplicationContext("com.lyh.samples");
        BBean bBean = (BBean) annoContext.getBean("BBean");
        bBean.methodB();

        //条件注解方式
        ApplicationContext configContext = new AnnotationConfigApplicationContext(AnnoConfiguration.class);
        CBean cBean = (CBean) configContext.getBean("cBean");
        cBean.methodC();

        DBean dBean = (DBean) configContext.getBean("dBean");
        dBean.methodD();
    }
}
