package com.currentbp.test.spring.cycleUseBean;

import com.alibaba.fastjson2.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baopan
 * @createTime 2020/7/30 10:12
 */
public class CycleStart1 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring.xml");
        Object beanA = applicationContext.getBean("beanA1");
        System.out.println(JSON.toJSON(beanA));
    }
}
