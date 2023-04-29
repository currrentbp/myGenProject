package com.currentbp.test.thread.interrupted;

/**
 * @author baopan
 * @createTime 2023/4/29 23:20
 */
public class MyThreadInterrupted {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("111111");
            Thread.currentThread().interrupt();
            System.out.println("22222222");
        }).start();

        try {
            System.out.println("333333");
            Thread.sleep(10000L);
            System.out.println("44444444");
        }catch (Exception e){

        }
    }
}
