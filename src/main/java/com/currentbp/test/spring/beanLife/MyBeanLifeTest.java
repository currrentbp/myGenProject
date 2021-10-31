package com.currentbp.test.spring.beanLife;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试bean的生命周期的
 *
 * @author baopan
 * @createTime 20211024
 */
public class MyBeanLifeTest {

    /**
     * 测试注解创建上下文，获取bean，检验创建bean后的初始化动作，销毁动作（销毁bean后）
     */
    @Test
    public void t1() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnotationStudent.class);
        AnnotationStudent ob = (AnnotationStudent) annotationConfigApplicationContext.getBean("annotationStudent");
        System.out.println(ob.getId());

        annotationConfigApplicationContext.close();
        /*
====>this is annotationStudent
====>this is init
1
====>this is destroy
         */
    }
}
