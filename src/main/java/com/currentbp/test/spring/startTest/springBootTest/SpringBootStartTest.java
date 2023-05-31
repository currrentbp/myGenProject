package com.currentbp.test.spring.startTest.springBootTest;

import com.currentbp.test.spring.startTest.springBootTest.commonBean.SpringPersonFun;
import com.currentbp.test.spring.startTest.springBootTest.commonBean.SpringPersonV1;
import com.currentbp.test.spring.startTest.springBootTest.commonBean.SpringPersonV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author baopan
 * @createTime 20210625
 */
@SpringBootApplication
public class SpringBootStartTest {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootStartTest.class, args);
        SpringPersonFun bean = context.getBean(SpringPersonV1.class);
        System.out.println(bean);

        SpringPersonFun bean2 = context.getBean(SpringPersonV2.class);
        System.out.println(bean2);
//
//        System.out.println(EnableAutoConfiguration.class.getName());
//
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("1","2222");
    }
}
