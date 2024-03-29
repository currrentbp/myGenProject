package com.currentbp.test.spring.startTest.springBootTest.commonBean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author baopan
 * @createTime 4/3/2023 9:02 AM
 */
@Component
public class SpringPersonV2 implements SpringPersonFun {
    private Integer id;
    private String name;

    @PostConstruct
    public void init() {
        this.id = 1;
        this.name = "111";
        System.out.println("SpringPerson init function end.");
        System.out.println("init this:" + this.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpringPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String sayHello() {
        return null;
    }

}
