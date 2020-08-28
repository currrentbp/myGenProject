package com.currentbp.thread;

/**
 * @author baopan
 * @createTime 2020/8/24 23:11
 */
public class StaticValueThreadTest {
    public static int value = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("value1:" + value);
                value++;
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("value2:" + value);
                value++;
            }).start();
        }
    }
}
