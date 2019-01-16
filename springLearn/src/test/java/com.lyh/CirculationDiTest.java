package com.lyh;

import com.lyh.beans.BeanRefernerce;
import com.lyh.beans.GenericBeanDefinition;
import com.lyh.beans.PreBuildBeanFactory;
import com.lyh.samples.CBean;
import com.lyh.samples.DBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 22:25
 */
public class CirculationDiTest {
    static PreBuildBeanFactory beanFactory = new PreBuildBeanFactory();

    @Test
    public void testCirculationDi()throws Exception{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(CBean.class);
        List defscc = new ArrayList<>();
        defscc.add(new BeanRefernerce("dd"));
        bd.setConstructorArgumentValues(defscc);
        beanFactory.registerBeanDefinition("cc", bd);

        bd = new GenericBeanDefinition();
        bd.setBeanClass(DBean.class);

        List defsdd = new ArrayList<>();
        defsdd.add(new BeanRefernerce("cc"));
        bd.setConstructorArgumentValues(defsdd);
        beanFactory.registerBeanDefinition("dd",bd);

        DBean dBean = (DBean)beanFactory.getBean("dd");
        System.out.println(dBean);
    }

}
