package com.currentbp.thread.producerConsumer.v20230130;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baopan
 * @createTime 1/30/2023 9:11 AM
 */
public class Store0130 {
    private AtomicInteger count = new AtomicInteger(0);
    private final int maxNum = 10;
    private final int retry = 3;

    public int addCount(int num) {
        int i = retry;
        while (i > 0) {
            int old = count.get();
            if (old + num > maxNum) {
                return 2;
            }
            boolean cas = count.compareAndSet(old, num + old);
            if (!cas) {
                i--;
                continue;
            }
            return 1;
        }
        return 3;
    }

    public int subCount(int num) {
        Object o = new Object();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        int i = retry;
        while (i > 0) {
            int old = count.get();
            if (old - num < 0) {
                System.out.println("subCount,old:" + old + " num:" + num);
                return 2;
            }
            boolean cas = count.compareAndSet(old, old - num);
            if (!cas) {
                i--;
                continue;
            }
            return 1;
        }
        return 3;
    }
}
