package com.currentbp.thread.semaphore;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author baopan
 * @createTime 1/27/2023 10:20 AM
 */
public class SimpleUseSemaphore {
    @Test
    public void t1() {
        //生产者和消费者模式
        //信号量可以理解为只有3个仓库
        //生产者最多可以生产3个
        //todo 但是这个例子有问题，消费者可以一直消费。。这是错误的
        Semaphore semaphore = new Semaphore(3);
        Thread producer = new Thread(() -> {
            try {
                for (; ; ) {
                    System.out.println("name:" + Thread.currentThread().getName() + "producter try one");
                    semaphore.acquire();
                    System.out.println("name:" + Thread.currentThread().getName() + "producter do one");
                    Thread.sleep(10);
                }

            } catch (Exception e) {
                System.out.println("==============");
                e.printStackTrace();
            }
        });
        producer.start();
        Thread consumer = new Thread(() -> {
            try {
                for (; ; ) {
                    System.out.println("name:" + Thread.currentThread().getName() + "consumer try one");
                    semaphore.release();
                    System.out.println("name:" + Thread.currentThread().getName() + "consumer eat one");
                    Thread.sleep(10);
                }
            } catch (Exception e) {
                System.out.println("==============");
                e.printStackTrace();
            }
        });
        consumer.start();

        System.out.println("two task is start ......");
        System.out.println("print semaphore:" + semaphore.toString());
        try {
            Thread.sleep(800L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
