package com.currentbp.test.spring.aop.jdkProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author baopan
 * @createTime 2023/5/31 15:28
 */
@SpringBootApplication
public class OnlyInterfaceJdkProxyStart {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OnlyInterfaceJdkProxyStart.class, args);
        OnlyInterface bean = context.getBean(OnlyInterface.class);
        System.out.println(bean.getOneStudent(1));
    }
}
