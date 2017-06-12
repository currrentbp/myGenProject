package com.bp.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 关于线程的相关测试
 *
 * @author current_bp
 * @createTime 20170204
 */
public class ThreadTest {
    private final static Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.sleepTest();
    }

    @Test
    public void sleepTest() {
        try {
            Thread.sleep(10000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    //此方法主要目的：验证是否存在锁，但是好像不是太符合要
    public void threadHoldsLock() {
        boolean hasHoldsLocal = Thread.currentThread().holdsLock(ThreadTest.class);
        logger.info("===>hasHoldsLocal:" + hasHoldsLocal);

        synchronized (ThreadTest.class) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    logger.info("===>thread1 is start...");
                    try {
                        Thread.sleep(1);
                        synchronized (this) {
                            wait();
                        }
                        logger.info("===>thread1 is over!!");
                    } catch (InterruptedException e) {
                        logger.info("===>msg:" + e.getMessage());
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    logger.info("===>thread2 is start...");
                    synchronized (this) {
                        logger.info("===>thread2 in syn");
                        try {
                            notifyAll();
                        } catch (Exception e) {
                            logger.info("===>thread2 is error!! msg:" + e.getMessage());
                        }
                    }
                    logger.info("===>thread2 is over!!");
                }
            });
            thread.start();
            boolean hasHoldsLocal2 = Thread.currentThread().holdsLock(ThreadTest.class);
            logger.info("===>hasHoldsLocal2:" + hasHoldsLocal2);
            thread2.start();
        }


    }

    @Test
    public void testThreadSleep() {
        System.out.println("===>now:" + new Date());
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===>2 seconds after.....\n===>time:" + new Date());
    }

    //==================       测试方法的私有方法         ===========================================================//
}
