package com.currentbp.thread.race;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baopan
 * @createTime 2020/4/24 17:20
 */
public class  AtomicIntegerPrint {

    private static AtomicInteger lock = new AtomicInteger(1);
    private static String s1 = "12345";
    private static String s2 = "ABCDE";

    public static void main(String[] args) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        new Thread(() -> {
            for (char c : c1) {
                while (1 != lock.get()) {
//                    System.out.println("========");
                }
                System.out.print(c);
                lock.compareAndSet(1, 2);
            }
        }).start();
        new Thread(() -> {
            for (char c : c2) {
                while (2 != lock.get()) {
//                    System.out.println("+++++++++");
                }
                System.out.print(c);
                lock.compareAndSet(2, 1);
            }
        }).start();

        try {
            Thread.sleep(10000);
        }catch (Exception e){

        }
        System.out.println("===>"+lock.get());
        System.out.println("===>"+lock.getAndIncrement());
        System.out.println("===>"+lock.get());
    }
}
