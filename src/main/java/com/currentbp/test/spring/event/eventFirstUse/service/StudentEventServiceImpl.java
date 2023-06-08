package com.currentbp.test.spring.event.eventFirstUse.service;

import com.currentbp.common.model.Student;
import com.currentbp.test.spring.event.eventFirstUse.event.CreateStudentEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 6/8/2023 10:05 AM
 */
@Service
public class StudentEventServiceImpl implements StudentEventService, ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public Student createStudent(int id, String name) {
        Student student = new Student(id, name);
        //发布一个创建学生的事件，作为监听者，会做出对应的事件
        this.publisher.publishEvent(new CreateStudentEvent(this, student));
        return student;
    }
}
