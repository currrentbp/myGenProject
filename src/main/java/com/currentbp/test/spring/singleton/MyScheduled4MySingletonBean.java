package com.currentbp.test.spring.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduled4MySingletonBean {
    @Autowired
    private MySingletonBean mySingletonBean;

    @Scheduled(cron = "0/5 * * * * ?")
//    @Async
    public void scheduled1() {
        mySingletonBean.setMyField("1");
        mySingletonBean.useMyField(Thread.currentThread().hashCode()+"");
    }

//    @Scheduled(cron = "0/5 * * * * ?")
////    @Async
//    public void scheduled2() {
//        mySingletonBean.setMyField("2");
//        mySingletonBean.useMyField(Thread.currentThread().hashCode()+"");
//    }
    /*
1、两个定时任务添加了 @Async的日志如下
myField:1 thread:176874321 currentName:176874321
myField:1 thread:1152012758 currentName:1152012758
myField:1 thread:1667818759 currentName:1667818759
myField:2 thread:459334764 currentName:459334764
myField:2 thread:2115374203 currentName:2115374203
myField:1 thread:1345129524 currentName:1345129524
myField:1 thread:904955956 currentName:904955956
myField:2 thread:290463581 currentName:290463581
2、两个定时任务没有添加@Async的日志如下：
myField:1 thread:924816352 currentName:924816352
myField:2 thread:924816352 currentName:924816352
myField:1 thread:924816352 currentName:924816352
myField:2 thread:924816352 currentName:924816352
myField:1 thread:924816352 currentName:924816352
myField:2 thread:924816352 currentName:924816352
myField:1 thread:924816352 currentName:924816352
myField:2 thread:924816352 currentName:924816352
myField:2 thread:924816352 currentName:924816352
myField:1 thread:924816352 currentName:924816352

     */
}
