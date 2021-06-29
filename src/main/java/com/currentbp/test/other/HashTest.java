package com.currentbp.test.other;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210625
 */
public class HashTest {
    @Test
    public void t1() {
        //两个hashcode相同
        int i = "AaAaAa".hashCode();// 0x7460e8c0
        int i1 = "BBAaBB".hashCode();// 0x7460e8c0
        System.out.println("i:" + i + " i1:" + i1);
    }
}
