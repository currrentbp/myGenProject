package com.currentbp.test.threadPoolTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @author baopan
 * @createTime 2023-06-13 16:06:41
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName(System.currentTimeMillis() + ".perfcounter");
                return t;
            }
        });

        for (int i = 0; i < 1000; i++) {
            final int x = i;
            Future<Integer> submit = executorService.submit(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("i:" + x + " thread:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return x;
            });
            try {
                Integer integer = submit.get();
                System.out.println("x==i? " + (x == integer));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
//            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
