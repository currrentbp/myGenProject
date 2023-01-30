package com.currentbp.thread.semaphore;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author baopan
 * @createTime 1/27/2023 10:54 AM
 */
public class StopCar {

    @Test
    public void t1() {
        Semaphore stoper = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println("name:" + Thread.currentThread().getName() + "尝试进入停车场。。。");
                    stoper.acquire();
                    long time = (long) (Math.random() * 10 + 1);
                    System.out.println("name:" + Thread.currentThread().getName() + "进入停车场，并停车" + time + "分钟");

                    Thread.sleep(time);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("name:" + Thread.currentThread().getName() + "尝试离开停车场！！！");
                    stoper.release();
                    System.out.println("name:" + Thread.currentThread().getName() + "离开停车场~~~");
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
