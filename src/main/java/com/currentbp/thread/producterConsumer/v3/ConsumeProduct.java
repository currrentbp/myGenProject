package com.currentbp.thread.producterConsumer.v3;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author baopan
 * @createTime 2020/6/24 14:08
 */
public class ConsumeProduct {

    private static volatile int currentNum = 0;
    private int maxNum = 5;

    private Object lock = new Object();

    @Test
    public void t1() {
        //product
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    while (currentNum + 1 > maxNum) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    currentNum = currentNum + 1;
                    System.out.println("生产者+1，剩余数量：" + currentNum);
                    lock.notifyAll();
                }
            }).start();
        }

        //consume
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    while (currentNum - 1 < 0) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    currentNum = currentNum - 1;
                    System.out.println("消费者-1，剩余数量：" + currentNum);
                    lock.notifyAll();

                }
            }).start();
        }

        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
    }

}

