package com.currentbp.test.spring.event.eventFirstUse.listener;

import com.currentbp.test.spring.event.eventFirstUse.event.CreateStudentEvent;
import com.currentbp.util.all.StringUtil;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 6/8/2023 10:17 AM
 */
@Service
public class TeacherListener {
    @Order(1)//同一种类型的消息可以设置顺序
    @EventListener
//    @Async //此处可以是异步的
    public void processCreateStudentEvent4Teacher(CreateStudentEvent event) {
        StringUtil.printObject("this is teacher ====>");
        StringUtil.printObject(event);
        StringUtil.printObject("this is teacher <====");
    }
}
