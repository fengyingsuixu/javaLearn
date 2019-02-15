package com.lyh;

import com.lyh.context.ApplicationContext;
import com.lyh.context.XmlApplicationContext;
import com.lyh.samples.ABean;
import org.junit.Test;

/**
 * Created by lvyanghui
 * 2019/2/15 18:05
 */
public class XmlTest {

    @Test
    public void testXml()throws Exception{

        ApplicationContext context = new XmlApplicationContext("classpath:applicationContext.xml");
        ABean aBean = (ABean)context.getBean("aBean");
        aBean.methodA();
    }
}
