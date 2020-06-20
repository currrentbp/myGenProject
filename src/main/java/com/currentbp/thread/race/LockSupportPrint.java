package com.currentbp.thread.race;

import java.util.concurrent.locks.LockSupport;

/**
 * @author baopan
 * @createTime 20200423
 */
public class LockSupportPrint {

    private static String c1 = "123456";
    private static String c2 = "ABCDEF";

    private static Thread thread1 = null;
    private static Thread thread2 = null;

    public static void main(String[] args) {
        char[] chars1 = c1.toCharArray();
        char[] chars2 = c2.toCharArray();

        thread1 = new Thread(() -> {
            for (char c : chars1) {
                System.out.print(c);
                LockSupport.unpark(thread2);//唤醒线程2
                LockSupport.park();//睡眠当前线程，不能提前关闭当前线程，否则无法唤醒线程2
            }
        });
        thread2 = new Thread(() -> {
            for (char c : chars2) {
                LockSupport.park();//先关闭自己线程，等待线程1唤醒自己
                System.out.print(c);
                LockSupport.unpark(thread1);//完成输出任务后，唤醒线程1
//                LockSupportPrint.class.notifyAll();

            }
        });

        thread1.start();
        thread2.start();
    }
}
