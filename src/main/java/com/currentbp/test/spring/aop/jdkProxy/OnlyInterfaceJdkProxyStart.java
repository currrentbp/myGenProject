package com.currentbp.test.spring.aop.jdkProxy;

import com.currentbp.common.model.Student;
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
        Student student1 = new Student();
        student1.setId(3);
        student1.setName("3333");
        int student = bean.createStudent(student1);
        System.out.println(student);
    }
}
