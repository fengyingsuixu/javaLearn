package com.lyh;

import com.lyh.beans.BeanRefernerce;
import com.lyh.beans.GenericBeanDefinition;
import com.lyh.beans.PreBuildBeanFactory;
import com.lyh.beans.PropertyValue;
import com.lyh.samples.ABean;
import com.lyh.samples.BBean;
import com.lyh.samples.BBeanFactory;
import com.lyh.samples.EBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 22:23
 */
public class BeanFactoryDITest {
    static PreBuildBeanFactory beanFactory = new PreBuildBeanFactory();

    @Test
    public void registerConstructorDI()throws Exception{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABean.class);
        beanFactory.registerBeanDefinition("aa01", bd);

        bd = new GenericBeanDefinition();
        bd.setBeanClass(BBean.class);

        List defs = new ArrayList<>();
        defs.add("lvyanghui");
        defs.add(new BeanRefernerce("aa01"));
        bd.setConstructorArgumentValues(defs);

        beanFactory.registerBeanDefinition("bb01",bd);

        beanFactory.preInstantiateSingletons();

        BBean bBean = (BBean)beanFactory.getBean("bb01");
        System.out.println(bBean);

    }

    @Test
    public void registerStaticFactoryMethod()throws Exception{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABean.class);
        beanFactory.registerBeanDefinition("aa02", bd);

        bd = new GenericBeanDefinition();
        bd.setBeanClass(BBeanFactory.class);
        bd.setFactoryMethodName("getBeanByFactory");

        List defs = new ArrayList<>();
        defs.add("lvyanghui");
        defs.add(new BeanRefernerce("aa02"));
        bd.setConstructorArgumentValues(defs);

        beanFactory.registerBeanDefinition("BBeanFactory",bd);
        beanFactory.preInstantiateSingletons();

        BBean bBean = (BBean)beanFactory.getBean("BBeanFactory");
        System.out.println(bBean);
    }

    @Test
    public void registerFactoryMethod()throws Exception{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABean.class);
        beanFactory.registerBeanDefinition("aa03", bd);

        bd = new GenericBeanDefinition();
        bd.setBeanClass(BBeanFactory.class);
        String fbname = "factory";
        beanFactory.registerBeanDefinition(fbname, bd);

        bd = new GenericBeanDefinition();
        bd.setFactoryBeanName(fbname);
        bd.setFactoryMethodName("getBeanByFactoryBean");

        List defs = new ArrayList<>();
        defs.add("lvyanghui");
        defs.add(new BeanRefernerce("aa03"));
        defs.add("ssssss");
        bd.setConstructorArgumentValues(defs);

        beanFactory.registerBeanDefinition("BBeanFactory01",bd);
        beanFactory.preInstantiateSingletons();

        BBean bBean = (BBean)beanFactory.getBean("BBeanFactory01");
        System.out.println(bBean);


    }

    @Test
    public void registerPropertyDI()throws Exception{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABean.class);
        beanFactory.registerBeanDefinition("aa04", bd);

        bd = new GenericBeanDefinition();
        bd.setBeanClass(EBean.class);

        PropertyValue property1 = new PropertyValue("name","lvyang");
        PropertyValue property2 = new PropertyValue("age",20);
        BeanRefernerce beanRefernerce = new BeanRefernerce("aa04");
        PropertyValue property3 = new PropertyValue("aBean",beanRefernerce);


        List<PropertyValue> propertyValues = new ArrayList<>();
        propertyValues.add(property1);
        propertyValues.add(property2);
        propertyValues.add(property3);
        bd.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("ee",bd);

        beanFactory.preInstantiateSingletons();

        EBean eBean = (EBean)beanFactory.getBean("ee");

        System.out.println(eBean.getName() + eBean.getAge() + eBean.getaBean());
        System.out.println(eBean);

    }

}
