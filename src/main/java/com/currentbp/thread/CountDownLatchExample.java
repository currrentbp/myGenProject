package com.currentbp.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baopan
 * @createTime 2020/6/20 17:00
 */
public class CountDownLatchExample {

    private final static int threadCount = 2000;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        Thread.sleep(270);
        System.out.println("task is dispatch ok");
        countDownLatch.await();
        System.out.println("finish");
        exec.shutdown();
        /**
         * 控制台结果：
         * 1823
         * task is dispatch ok
         * 1932
         * 1936
         *
         * 表明线程的任务先执行，然后主线程的await使得主线程等待，直到countDown到0，
         * 才向下执行
         */
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        System.out.println(threadNum);
        Thread.sleep(100);
    }



}
