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
        //直接写默认的路径，可以获取该路径下的所有bean
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.currentbp.test.spring.aop");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MyAopConfig.class);
        MyAopService m = ac.getBean(MyAopService.class);
        String myStudent = m.getMyStudent(1);
        System.out.println("===>"+myStudent);
    }
}
