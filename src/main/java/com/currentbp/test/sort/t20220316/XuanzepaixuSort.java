package com.currentbp.test.sort.t20220316;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class XuanzepaixuSort {
    /*
选择排序
     */
    @Test
    public void t1() {
        int[] ints = {11, 1, 3, 2, 7, 5};
        myXuanzepaixu(ints);
        StringUtil.printObject(ints);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1,2);
        System.out.println(atomicInteger.get());
    }

    private void myXuanzepaixu(int[] ints) {
        int currentIndex = 0;
        while (currentIndex < ints.length) {
            int nowMinIndex = currentIndex;
            for (int tempIndex = currentIndex; tempIndex < ints.length; tempIndex++) {
                if (ints[tempIndex] < ints[nowMinIndex]) {
                    nowMinIndex = tempIndex;
                }
            }
            if (ints[currentIndex] > ints[nowMinIndex]) {
                swap(ints, currentIndex, nowMinIndex);
            }
            currentIndex++;
        }
    }

    private void swap(int[] ints, int left, int right) {
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }

}
