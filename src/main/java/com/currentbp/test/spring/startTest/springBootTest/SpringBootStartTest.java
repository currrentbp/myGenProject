package com.currentbp.test.spring.startTest.springBootTest;

import com.currentbp.test.spring.startTest.springBootTest.commonBean.SpringPersonV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;

/**
 * @author baopan
 * @createTime 20210625
 */
@SpringBootApplication
public class SpringBootStartTest {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootStartTest.class, args);
//        SpringPersonV1 bean = context.getBean(SpringPersonV1.class);
//        System.out.println(bean);
//
//        System.out.println(EnableAutoConfiguration.class.getName());
//
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("1","2222");
    }
}
