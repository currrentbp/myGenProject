package com.currentbp.test.threadPoolTest;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author baopan
 * @createTime 20221017
 */
public class ScheduledTest {
    /*
这是一个定时任务
     */
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName(Thread.currentThread().getId() + ".perfcounter");
            return t;
        }
    });
    private static PerfCounterPushTask pushTask;

    public static void main(String[] args) {
        pushTask = new PerfCounterPushTask();
        scheduler.scheduleAtFixedRate(pushTask, 5 * 1000, 5 * 1000, TimeUnit.MILLISECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("====>shutdown");
                scheduler.shutdown();
            }
        }));
        try {
            Thread.sleep(1 * 60 * 60 * 1000);
        } catch (Exception e) {
            System.out.println("====>sleep error" + e.getMessage());
        }
    }
}

class PerfCounterPushTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("======>" + System.currentTimeMillis());
    }
}
