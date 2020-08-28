package com.currentbp.thread.race;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author baopan
 * @createTime 20200423
 */
public class SemaphorePrint {

    private static String c1 = "123456";
    private static String c2 = "ABCDEF";

    private static Thread thread1 = null;
    private static Thread thread2 = null;

    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(0);


    public static void main(String[] args) {
        char[] chars1 = c1.toCharArray();
        char[] chars2 = c2.toCharArray();

        thread1 = new Thread(() -> {
            try {
                for (char c : chars1) {
                    s1.acquire();
                    System.out.print(c);
                   s2.release();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        thread2 = new Thread(() -> {
            try {
                for (char c : chars2) {
                    s2.acquire();
                    System.out.print(c);
                   s1.release();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
