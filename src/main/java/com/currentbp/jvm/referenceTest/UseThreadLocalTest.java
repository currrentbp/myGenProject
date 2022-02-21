package com.currentbp.jvm.referenceTest;

public class UseThreadLocalTest {
    public void useTl() {
        ThreadLocal<Long> saveVar = ThreadLocalTest.saveVar;
        System.out.println("threadName:" + Thread.currentThread().getName() + " saveVar:" + saveVar.get());
    }
}
