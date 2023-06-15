package com.currentbp.test.spring.aop.aopTest;

import com.currentbp.common.model.Student;
import com.currentbp.test.spring.aop.multAop.service.MultAopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author baopan
 * @createTime 20210625
 */
@SpringBootApplication
public class SpringSimpleAopStartMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringSimpleAopStartMain.class, args);
        SimpleAopService bean = context.getBean(SimpleAopService.class);
        Student s = bean.getById(1);
        System.out.println(s);


    }
}
