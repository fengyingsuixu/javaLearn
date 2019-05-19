package com.lyh.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by lvyanghui
 * 2019/5/13 22:10
 */
public class JavaMailClient {

    private String host = "smtp.163.com";
    private String port = "25";
    private String userName = "lvyanghui1990@163.com";
    private String password = "97135566lvyh";
    private String to = "550352082@qq.com";

    public void sendTextMail() throws Exception {
        Properties pro = System.getProperties();
        pro.put("mail.smtp.host", host);
        //pro.put("mail.smtp.port", port);
        pro.put("mail.transport.protocol" , "smtp");
        pro.put("mail.smtp.auth", "true");

        pro.setProperty("mail.smtp.socketFactory.class" , "javax.net.ssl.SSLSocketFactory");
        pro.setProperty("mail.smtp.socketFactory.fallback" , "false");
        pro.setProperty("mail.smtp.port" , "465");
        pro.setProperty("mail.smtp.socketFactory.port" , "465");



        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        // 根据session创建一个邮件消息
        Message mailMessage = new MimeMessage(sendMailSession);
        // 设置邮件消息的发送者
        mailMessage.setFrom(new InternetAddress(userName));
        // 创建邮件的接收者地址，并设置到邮件消息中
        mailMessage.setRecipient(Message.RecipientType.TO,
                new InternetAddress(to));
        mailMessage.setRecipient(Message.RecipientType.CC , new InternetAddress(userName));
        // 设置邮件消息的主题
        mailMessage.setSubject("Test Email");
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());
        // 设置邮件消息的主要内容
        mailMessage.setText("this is a test Text mail");
        // 发送邮件
        Transport.send(mailMessage);
    }

    public static void main(String[] args) throws Exception{
        new JavaMailClient().sendTextMail();
    }
}
