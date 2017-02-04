package com.bp.test;

import java.util.Date;

/**
 * 关于线程的相关测试
 *
 * @author current_bp
 * @createTime 20170204
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.testThreadSleep();
    }


    public void testThreadSleep() {
        System.out.println("===>now:" + new Date());
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===>2 seconds after.....\ntime:" + new Date());
    }
}
