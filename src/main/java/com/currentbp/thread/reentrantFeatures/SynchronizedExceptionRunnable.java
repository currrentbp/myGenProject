package com.currentbp.thread.reentrantFeatures;

/**
 * @author baopan
 * @createTime 2020/8/11 10:59
 */
public class SynchronizedExceptionRunnable implements Runnable {

    private volatile boolean flag = true;

    public static void main(String[] args) {
        SynchronizedExceptionRunnable runnable = new SynchronizedExceptionRunnable();

        Thread thread1 = new Thread(runnable,"杯子");
        Thread thread2 = new Thread(runnable,"人");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (SynchronizedExceptionRunnable.class) {
            if (flag) {
                //让先启动的线程先执行异常方法methodB后，flag==false，并且抛出异常线程停止，直接释放锁，不会执行后面的代码；
                methodB();
            } else {
                //后启动的线程再获取锁，进入if-else,再获取锁执行methodA
                methodA();
            }
            System.out.println("" + Thread.currentThread().getName() + ":if-else end");
        }
    }

    public synchronized void methodA(){
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "----methodA");
    }

    public synchronized void  methodB() {
        flag = false;
        System.out.println("ThreadName:" + Thread.currentThread().getName() + "----methodB will throw a exception!");

        //如果把下面这行抛异常的代码注释掉，会执行下面的线程睡眠5秒和最后的日志代码
        //如果不注释，会抛出异常，不在执行后面的代码，并且释放锁，methodA方法就会执行
        int a = 1/0;


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:{}----methodB End!"+Thread.currentThread().getName());
    }
}
