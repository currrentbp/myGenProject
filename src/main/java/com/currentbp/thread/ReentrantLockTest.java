package com.currentbp.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试reentrantLock与synchronized的性能
 *
 * @author current_bp
 * @createTime 20170605
 */
public class ReentrantLockTest {
    private final static Logger logger = LoggerFactory.getLogger(ReentrantLockTest.class);

    public static int staticValue = 0;

    @Test
    public void useSynchronized() {

        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(new Thread1());
            thread.start();
        }


        //此处如果没有，子线程可能无法完全执行
        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void useReentrantLock() {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new Thread3());
            thread.start();
        }

        //此处如果没有，子线程可能无法完全执行
        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    class Thread1 implements Runnable {
        public void run() {
            synchronized (ReentrantLockTest.class) {
                ++staticValue;
                try {
                    logger.info("===>staticValue:" + staticValue);
                } catch (Exception e) {
                    System.out.println("===>msg:" + e.getMessage());
                }
            }
        }
    }


    class Thread3 implements Runnable {
        public void run() {
            Lock lock = new ReentrantLock();
            lock.lock();
            try {
                ++staticValue;
                logger.info("===>staticValue:" + staticValue);
            } finally {
                lock.unlock();
            }
        }
    }


}
