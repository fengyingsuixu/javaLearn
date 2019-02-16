package com.lyh.context;

import com.lyh.beans.BeanDefinitionRegistry;
import com.lyh.beans.GenericBeanDefinition;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/14 18:00
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws Exception {

        InputStream inputStream = resource.getInputStream();

        parseXml(inputStream);
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws Exception {

        if(null != resources && resources.length > 0){
            for(Resource resource : resources){
                loadBeanDefinitions(resource);
            }
        }
    }

    //解析xml
    public void parseXml(InputStream inputStream)throws Exception{

        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建DocumentBuilder对象
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document document = db.parse(inputStream);
        //获取所有节点的集合
        Element element = document.getDocumentElement();

        NodeList childNodes = element.getChildNodes();
        for (int i = 0,len = childNodes.getLength(); i < len; i++) {
            Node item = childNodes.item(i);
            if("bean".equals(item.getNodeName())){
                parseBean(item);
            }
        }
    }

    // 创建bean对象 注册bean对象
    public void parseBean(Node item)throws Exception{
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        NamedNodeMap attributes = item.getAttributes();
        for (int j = 0,leng = attributes.getLength(); j < leng; j++) {
            Node attr = attributes.item(j);
            if("id".equals(attr.getNodeName())){
                registry.registerBeanDefinition(attr.getNodeValue(),beanDefinition);
            }
            if("class".equals(attr.getNodeName())){
                beanDefinition.setBeanClass(Class.forName(attr.getNodeValue()));
            }
        }
    }
}
