package com.currentbp.test.spring.aop.jdkAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author baopan
 * @createTime 20220411
 */
public class UseJdkAop {
    public static void main(String[] args) {
        //todo not work
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.currentbp.test.spring.aop.jdkAop");
        JdkDemo jdkDemo = ac.getBean("jdkDemo", JdkDemo.class);
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

        String s = jdkDemo.doSomething("1111");

    }
}

interface JdkDemo {
    String doSomething(String str);
}

@Component
class JdkDemoImpl implements JdkDemo {
    @Override
    public String doSomething(String str) {
        return "this is str:" + str;
    }
}
