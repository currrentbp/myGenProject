package com.currentbp.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author baopan
 * @createTime 2020/6/20 17:29
 */
public class CyclicBarrierExample {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
//            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();

        /**控制台结果：
         * 0 is ready
         * 1 is ready
         * 2 is ready
         * 3 is ready
         * 4 is ready
         * 4 continue
         * 0 continue
         * 2 continue
         * 1 continue
         * 3 continue
         * 5 is ready
         * 6 is ready
         * 7 is ready
         * 8 is ready
         * 9 is ready
         * 9 continue
         * 5 continue
         * 6 continue
         * 8 continue
         * 7 continue
         */

        /**
         * 控制台结果：没有sleep
         * 0 is ready
         * 1 is ready
         * 2 is ready
         * 3 is ready
         * 4 is ready
         * 5 is ready
         * 4 continue
         * 0 continue
         * 2 continue
         * 3 continue
         * 1 continue
         * 6 is ready
         * 7 is ready
         * 8 is ready
         * 9 is ready
         * 9 continue
         * 5 continue
         * 8 continue
         * 7 continue
         * 6 continue
         */
    }

    private static void race(int threadNum) throws Exception {
//        Thread.sleep(1000);
        System.out.println(threadNum+" is ready");
        barrier.await();
        System.out.println(threadNum+" continue");
    }
}
