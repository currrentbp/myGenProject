package com.currentbp.test.spring.event.eventFirstUse.listener;

import com.currentbp.test.spring.event.eventFirstUse.event.CreateStudentEvent;
import com.currentbp.util.all.StringUtil;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 6/8/2023 10:18 AM
 */
@Service
public class ScoreListener {
    @Order(2)//同一种类型的消息可以设置顺序
    @EventListener
//    @Async //此处可以是异步的
    public void processCreateStudentEvent4Score(CreateStudentEvent event) {
        StringUtil.printObject("this is score ====>");
        StringUtil.printObject(event);
        StringUtil.printObject("this is score <======");
    }
}
