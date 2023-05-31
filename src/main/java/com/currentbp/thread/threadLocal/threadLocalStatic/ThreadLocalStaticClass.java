package com.currentbp.thread.threadLocal.threadLocalStatic;

import java.util.Random;

/**
 * @author baopan
 * @createTime 2023/5/21 21:44
 */
public class ThreadLocalStaticClass {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int j = i;
            new Thread(() -> {
                StaticAbsClass.setTl("t" + j);
                try {
                    Thread.sleep(10 + (new Random().nextInt(5)));
                } catch (Exception e) {
                    System.out.println(e);
                }

                String tl = StaticAbsClass.getTl();
                System.out.println("thread:" + j + " value:" + tl);
                if(!tl.equals("t"+j)){
                    System.out.println("=========>");
                }

            }, "thread:" + i).start();
        }
    }
}
