package com.currentbp.test.spring.aop.multAop;

import com.currentbp.test.spring.aop.multAop.service.MultAopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author baopan
 * @createTime 20210625
 */
@SpringBootApplication
public class SpringMultAopStartMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringMultAopStartMain.class, args);
        MultAopService bean = context.getBean(MultAopService.class);
        String s = bean.doSome("2");
        System.out.println(s);


    }
}
