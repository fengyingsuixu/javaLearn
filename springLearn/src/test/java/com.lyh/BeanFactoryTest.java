package com.lyh;

import com.lyh.beans.BeanDefinition;
import com.lyh.beans.BeanDefinitionRegistryException;
import com.lyh.beans.DefaultBeanFactory;
import com.lyh.beans.GenericBeanDefinition;
import com.lyh.samples.ABean;
import com.lyh.samples.ABeanFactory;
import org.junit.AfterClass;
import org.junit.Test;

/**
 * Created by lvyanghui
 * 2019/1/16 22:24
 */
public class BeanFactoryTest {
    static DefaultBeanFactory beanFactory = new DefaultBeanFactory();

    @Test
    public void register()throws BeanDefinitionRegistryException {

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABean.class);
        //bd.setScope("singleton");
        //bd.setScope("prototype");
        bd.setInitMethodName("initMethod");
        bd.setDestroyMethodName("destoryA");
        beanFactory.registerBeanDefinition("aa", bd);
    }

    @Test
    public void registerStaticFactoryMethod()throws BeanDefinitionRegistryException{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABeanFactory.class);
        bd.setFactoryMethodName("getBeanByFactory");

        beanFactory.registerBeanDefinition("ABeanFactory", bd);
    }

    @Test
    public void registerFactoryMethod()throws BeanDefinitionRegistryException{

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABeanFactory.class);
        String fbname = "factory";
        beanFactory.registerBeanDefinition(fbname, bd);

        bd = new GenericBeanDefinition();
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        bd.setFactoryBeanName(fbname);
        bd.setFactoryMethodName("getBeanByFactoryBean");
        beanFactory.registerBeanDefinition("ABeanFactory01",bd);

    }

    @AfterClass
    public static void testFactory()throws Exception{

        System.out.println("spring 构造方式------------");
        for (int i = 0; i < 3; i++) {
            ABean abean = (ABean)beanFactory.getBean("aa");
            System.out.println(abean);
        }


        System.out.println("spring 静态工厂方式------------");
        for (int i = 0; i < 3; i++) {
            ABean abean = (ABean)beanFactory.getBean("ABeanFactory");
            System.out.println(abean);
        }

        System.out.println("spring 工厂方法方式------------");
        for (int i = 0; i < 3; i++) {
            ABean abean = (ABean)beanFactory.getBean("ABeanFactory01");
            System.out.println(abean);
        }
    }

}
