package com.currentbp.test.spring.aop.jdkAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试jdk的动态代理
 * @author baopan
 * @createTime 20220407
 */
public class JdkAopTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    class Parent{

    }
}
