package com.currentbp.util.all;

import org.junit.Test;

import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * 关于email发送
 *
 * @author baopan
 * @createTime 20200525
 */
public class EmailUtil {

    /**
     * 简单的发送邮件
     *
     * @param from    发件人邮箱
     * @param to      收件人邮箱
     * @param host    指定发送邮件的主机：如：mail.gaosiedu.com
     * @param subject 头部头字段
     * @param content 发送的消息
     */
    public static void sendSimpleEmail(String from,
                                       String to,
                                       String host,
                                       String subject,
                                       String content) {
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties);

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: 头部头字段
            message.setSubject(subject);
            // 设置消息体
            message.setText(content);

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


}
