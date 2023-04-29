package com.currentbp.Interesting.likou.complete;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author baopan
 * @createTime 2020/6/22 10:28
 */
public class T1115 {


    public static void main(String[] args) throws InterruptedException {
        FooBar3 fooBar = new FooBar3(3);
        new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


}

class FooBar {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            foo.acquire();
            printFoo.run();
            bar.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            bar.acquire();
            printBar.run();
            foo.release();

        }

    }

}

class FooBar2 {
    private int n;
    private Object lock = new Object();


    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.notifyAll();
                lock.wait();
            }
            lock.notifyAll();//避免两个线程走完了，主线程不继续的问题
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notifyAll();
                lock.wait();
            }
            lock.notifyAll();//避免两个线程走完了，主线程不继续的问题
        }
    }

}


class FooBar3 {
    private int n;
    Thread t1 = null;
    Thread t2 = null;

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        t1 = Thread.currentThread();

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            if (null != t2) {
                LockSupport.unpark(t2);
            }
            if (i + 1 < n) {//防止因为自身wait了导致主线程无法继续走下去
                LockSupport.park();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        t2 = Thread.currentThread();
        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.

            printBar.run();
            LockSupport.unpark(t1);
            if (i + 1 < n) {//防止因为自身wait了导致主线程无法继续走下去
                LockSupport.park();
            }

        }
    }

}
