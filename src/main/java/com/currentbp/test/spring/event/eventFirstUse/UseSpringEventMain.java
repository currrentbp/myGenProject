package com.currentbp.test.spring.event.eventFirstUse;

import com.currentbp.test.spring.event.eventFirstUse.service.StudentEventService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author baopan
 * @createTime 6/8/2023 10:01 AM
 */
@SpringBootApplication
public class UseSpringEventMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(UseSpringEventMain.class, args);
        StudentEventService bean = context.getBean(StudentEventService.class);
        System.out.println(bean.createStudent(1, "1"));
    }
}
