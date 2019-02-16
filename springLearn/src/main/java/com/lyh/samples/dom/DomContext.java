package com.lyh.samples.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvyanghui
 * 2019/2/15 22:49
 */
public class DomContext {

    public static void main(String[] args) {
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //创建一个DocumentBuilder的对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
            InputStream in = DomContext.class.getResourceAsStream("/applicationContext.xml");
            Document document = db.parse(in);
            //获取所有book节点的集合
            Element element = document.getDocumentElement();

            NodeList childNodes = element.getChildNodes();
            for (int i = 0,len = childNodes.getLength(); i < len; i++) {
                Node item = childNodes.item(i);
                if("bean".equals(item.getNodeName())){
                    NamedNodeMap attributes = item.getAttributes();
                    for (int j = 0,leng = attributes.getLength(); j < leng; j++) {
                        Node attr = attributes.item(j);
                        System.out.println("node名字 " + attr.getNodeName() + " 值 " + attr.getNodeValue());
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
