package com.currentbp.test.spring.event.eventFirstUse.event;

import com.currentbp.common.model.Student;
import org.springframework.context.ApplicationEvent;

/**
 * @author baopan
 * @createTime 6/8/2023 10:09 AM
 */
public class CreateStudentEvent extends ApplicationEvent {
    /*
    这是一个事件
     */
    private Student student;

    public CreateStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
