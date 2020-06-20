package com.currentbp.thread.threadLocal;

import java.util.concurrent.Executors;

/**
 * @author baopan
 * @createTime 2020/6/18 10:16
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    private static class Thread4Local extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                local.set(i);
                System.out.println(getName()+" "+local.get());
            }
        }
    }

    public static void main(String[] args) {
        Thread4Local t1 = new Thread4Local();
        Thread4Local t2 = new Thread4Local();

        t1.start();
        t2.start();


        /*
执行结果:
Thread-1 0
Thread-1 1
Thread-1 2
Thread-1 3
Thread-1 4
Thread-0 0
Thread-1 5
Thread-0 1
Thread-1 6
Thread-1 7
Thread-0 2
Thread-1 8
Thread-0 3
Thread-1 9
Thread-0 4
Thread-0 5
Thread-0 6
Thread-0 7
Thread-0 8
Thread-0 9
         */
    }
}
