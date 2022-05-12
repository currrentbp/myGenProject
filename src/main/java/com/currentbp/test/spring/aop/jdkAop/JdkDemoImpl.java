package com.currentbp.test.spring.aop.jdkAop;

import org.springframework.stereotype.Component;

@Component
public class JdkDemoImpl implements JdkDemo {
    @Override
    public String doSomething(String str) {
        System.out.println("=====>str:"+str);
        return "this is str:" + str;
    }
}