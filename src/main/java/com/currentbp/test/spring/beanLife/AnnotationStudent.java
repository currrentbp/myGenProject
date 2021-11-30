package com.currentbp.test.spring.beanLife;

import com.currentbp.common.model.Student;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;


public class AnnotationStudent {
//    @Resource
    private Integer id = 1;


    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AnnotationStudent doAnnotationStudent() {
        System.out.println("====>this is annotationStudent");
        return new AnnotationStudent();
    }

    public String getId() {
        return "" + id;
    }

    public void init() {
        System.out.println("====>this is init");
    }

    public void destroy() {
        System.out.println("====>this is destroy");
    }
}
