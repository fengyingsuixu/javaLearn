package com.lyh;

import com.lyh.context.AnnotationnApplicationContext;
import com.lyh.context.ApplicationContext;
import com.lyh.samples.ABean;
import org.junit.Test;

/**
 * Created by lvyanghui
 * 2019/2/15 18:05
 */
public class AnnotationTest {

    @Test
    public void testAnnotation()throws Exception{

        ApplicationContext context = new AnnotationnApplicationContext("com.lyh.samples");
        ABean aBean = (ABean)context.getBean("aBean");
        aBean.methodA();
    }
}
