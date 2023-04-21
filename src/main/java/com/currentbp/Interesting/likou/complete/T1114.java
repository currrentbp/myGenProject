package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baopan
 * @createTime 2020/6/20 12:05
 */
public class T1114 {

    @Test
    public void t1() throws InterruptedException {
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");

        Foo foo = new Foo();

        new Thread(() -> {
            try {
                foo.second(r2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(r1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(r3);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(12);
    }

    @Test
    public void t2() throws InterruptedException {
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");

        Foo2 foo2 = new Foo2();

        new Thread(() -> {
            try {
                foo2.second(r2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo2.first(r1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo2.third(r3);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1234);

    }

    @Test
    public void t3() throws InterruptedException {
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");

        Foo3 foo3 = new Foo3();

        new Thread(() -> {
            try {
                foo3.second(r2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo3.first(r1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo3.third(r3);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1234123);

    }


    class Foo {
        private AtomicInteger lock = new AtomicInteger(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            while (1 != lock.get()) {
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            lock.compareAndSet(1, 2);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (2 != lock.get()) {
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock.compareAndSet(2, 3);
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (3 != lock.get()) {
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    class Foo2 {

        AtomicInteger orderBy = new AtomicInteger(1);
        Object object = new Object();

        public Foo2() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (object) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                orderBy.compareAndSet(1, 2);
                object.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (object) {
                while (2 != orderBy.get()) {
                    object.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                orderBy.compareAndSet(2, 3);
                object.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (object) {
                while (3 != orderBy.get()) {
                    object.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                object.notifyAll();
            }
        }
    }

    class Foo3 {
        private Semaphore two = new Semaphore(0);//设置通行证（信号量），初始值为0，表示无法通过的意思
        private Semaphore three = new Semaphore(0);
        public Foo3() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            two.release();//释放一个通行证，
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            two.acquire();//获取一个通行证，获取失败后直接进入阻塞状态
            printSecond.run();
            three.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            three.acquire();
            printThird.run();
        }
    }
}
