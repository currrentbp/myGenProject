package com.currentbp.test.spring.aop.jdkAop;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20220411
 */
public class UseJdkAop {
    public static void main(String[] args) {
        //todo not work
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.currentbp.test.spring.aop.jdkAop");
        JdkDemo jdkDemo = ac.getBean(JdkDemo.class);
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                System.out.println("=====>before=====");
                res = method.invoke(jdkDemo, args);
                System.out.println("=====>after=====");
                return res;
            }
        };

        /*
        ClassLoader loader,    对象对应类的字节码
      Class<?>[] interfaces,   类实现的接口，这就是jdk代理只能代理实现接口的方式
      InvocationHandler h      jdk的代理内容
         */
        JdkDemo newJdkDemo = (JdkDemo)Proxy.newProxyInstance(jdkDemo.getClass().getClassLoader(), jdkDemo.getClass().getInterfaces(), invocationHandler);

        String s = newJdkDemo.doSomething("1111");

    }
}
