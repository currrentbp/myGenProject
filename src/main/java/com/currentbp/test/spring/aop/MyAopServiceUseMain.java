package com.currentbp.test.spring.aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author baopan
 * @createTime 20220221
 */
public class MyAopServiceUseMain {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AopContext.class);
        MyAopService m = ac.getBean(MyAopService.class);
        String myStudent = m.getMyStudent(1);
        System.out.println("===>"+myStudent);
    }
}
