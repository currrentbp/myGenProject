package com.currentbp.jvm.referenceTest;

public class ThreadLocalTest {
    public static ThreadLocal<Long> saveVar = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                long l = System.currentTimeMillis();
                saveVar.set(l);
                System.out.println("threadName:" + Thread.currentThread().getName() + " l:" + l);
                UseThreadLocalTest useThreadLocalTest = new UseThreadLocalTest();
                useThreadLocalTest.useTl();
            }).start();
        }
    }
}
