package com.currentbp.test.spring.aop.multAop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author baopan
 * @createTime 20210625
 */
@SpringBootApplication
public class SpringMultAopStartTest {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringMultAopStartTest.class, args);
//        SpringPersonV1 bean = context.getBean(SpringPersonV1.class);
//        System.out.println(bean);
//
//        System.out.println(EnableAutoConfiguration.class.getName());
//
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("1","2222");
    }
}
