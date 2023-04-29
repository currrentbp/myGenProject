package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author baopan
 * @createTime 2020/6/22 14:29
 */
public class T1116 {

    @Test
    public void t1() throws InterruptedException {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(2);
        IntConsumer intConsumer = (x) -> {
            System.out.print(x);
        };
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(100);
    }


}


class ZeroEvenOdd {
    private int n;
    private volatile int index = 0;

    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (; index < n; ) {
            zero.acquire();
            printNumber.accept(0);
            index++;

            if (index % 2 == 0) {
                odd.release();
            } else if (index % 2 == 1) {
                even.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (; index <= n; ) {
            even.acquire();
            printNumber.accept(index);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (; index <= n; ) {
            odd.acquire();
            printNumber.accept(index);
            zero.release();
        }
    }
}


class ZeroEvenOdd2{
    private int n;
    private boolean flag = false; //是否零阻塞

    private int count = 0;


    Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();


    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                while (flag) {
                    zero.await();
                }
                printNumber.accept(0);
                count++;
                flag = !flag;
                if (i % 2 == 0) {
                    even.signalAll();//偶数
                } else {
                    odd.signalAll();//奇数
                }

            }
//            System.out.print("0");


        } finally {

            lock.unlock();

        }

    }

    /**
     * 偶数
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (; count < n; ) {
                if(n==1){
                    break;
                }
                if (n > 1) {
                    if (n % 2 != 0 && count == n - 1) {
                        break;
                    }
                }
                while (!flag||count%2!=0) {
                    even.await();
                }

                printNumber.accept(count);
                flag = !flag;
                zero.signalAll();

            }
        } finally {

            lock.unlock();
//            System.out.println("解锁偶数");

        }

    }

    /**
     * 奇数
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {

            if (count == 1 && n == 1) {
                printNumber.accept(count);

            }
            for (; count < n; ) {
                if (n > 2) {
                    if (n % 2 == 0 && count == n - 1) {
                        break;
                    }
                }
                while (!flag || count % 2 == 0) {
                    odd.await();
                }
                printNumber.accept(count);
                flag = !flag;
                zero.signalAll();
                if (n == 2) {
                    break;
                }
            }

        } finally {
            lock.unlock();
//            System.out.println("解锁奇数");
        }
    }
}

/*
假设有这么一个类：
class ZeroEvenOdd {
  public ZeroEvenOdd(int n) { ... }      // 构造函数
  public void zero(printNumber) { ... }  // 仅打印出 0
  public void even(printNumber) { ... }  // 仅打印出 偶数
  public void odd(printNumber) { ... }   // 仅打印出 奇数
}
相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
线程 A 将调用 zero()，它只输出 0 。
线程 B 将调用 even()，它只输出偶数。
线程 C 将调用 odd()，它只输出奇数。
每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
示例 1：
输入：n = 2
输出："0102"
说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
示例 2：
输入：n = 5
输出："0102030405"
 */
