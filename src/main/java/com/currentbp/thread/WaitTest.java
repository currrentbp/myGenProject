package com.currentbp.thread;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/6/24 11:21
 */
public class WaitTest {

    @Test
    public void t1() throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread1 index:" + i);
                    if (i == 5) {
                        try {
                            System.out.println("sleep index:" + i);
                            lock.wait(100000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread2 index:" + i);
                }
            }
        }).start();
        Thread.sleep(1111111);
    }
}
