package com.currentbp.test;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20200120
 */
public class SwapTest {


    @Test
    public void t1() {
        for (int i = 0; i < 10; i++) {
            doSwap();
        }
    }

    private void doSwap() {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            swap1(i, i + 1);
        }
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            swap2(i, i + 1);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("swap1Time:" + (end1 - start1) + " swap2Time:" + (end2 - start2));
    }
/*
这两个swap的耗时基本一致
 */
    private void swap1(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
//        System.out.println("a:"+a+" b:"+b);
    }

    private void swap2(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
