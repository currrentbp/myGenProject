package com.currentbp.thread.reentrantFeatures;

import java.util.Hashtable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author baopan
 * @createTime 2020/8/11 10:59
 */
public class ReentrantLockExceptionRunnable implements Runnable {

    private volatile boolean flag = true;
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockExceptionRunnable runnable = new ReentrantLockExceptionRunnable();

        Thread thread1 = new Thread(runnable, "杯子");
        Thread thread2 = new Thread(runnable, "人");
        thread1.start();
        thread2.start();

        new Hashtable<>();
    }

    @Override
    public void run() {
        lock.lock();
        if (flag) {
            //让先启动的线程先执行异常方法methodB后，flag==false，并且抛出异常线程停止，直接释放锁，不会执行后面的代码；
            methodB();
        } else {
            //后启动的线程再获取锁，进入if-else,再获取锁执行methodA
            methodA();
        }
        System.out.println("" + Thread.currentThread().getName() + ":if-else end");
        lock.unlock();
    }

    public void methodA() {
        lock.lock();
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "----methodA");
        lock.unlock();
    }

    public void methodB() {
        lock.lock();
        flag = false;
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "----methodB will throw a exception!");

        int a = 1/0;//此处有异常，如果没有捕获，会导致下面的锁无法释放，第二个进程都无法执行


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "----methodB End!");
        lock.unlock();
    }
}
