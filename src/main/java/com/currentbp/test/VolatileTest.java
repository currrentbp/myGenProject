package com.currentbp.test;

/**
 * @author current_bp
 * @createTime 20171115
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    /*
    程序有问题：可能一直死循环
     */
    private static final int THREADS_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 500000; i++) {
                        increase();
                    }
                }
            }
            );
            threads[i].start();
        }//等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
