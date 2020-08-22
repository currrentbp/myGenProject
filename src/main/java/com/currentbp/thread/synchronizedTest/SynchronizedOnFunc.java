package com.currentbp.thread.synchronizedTest;

import org.junit.Test;

import java.util.Random;

/**
 * @author baopan
 * @createTime 2020/8/11 21:11
 */
public class SynchronizedOnFunc {

    public static void main(String[] args) {
        SynchronizedOnFunc s1 = new SynchronizedOnFunc();
        SynchronizedOnFunc s2 = new SynchronizedOnFunc();
        new Thread(()->{
            for(int i=0;i<5;i++){
                s1.doSomeThings("===>");
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                s1.doSomeThings2("+++>");
            }
        }).start();
        try {
            Thread.sleep(1000);
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }

    public synchronized void doSomeThings(String pre){
        System.out.println(pre+" doSomeThings's start.....");
        try {
            Thread.sleep(10+new Random().nextInt(3));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(pre+" doSomeThings's end!!!");
    }

    public synchronized void doSomeThings2(String pre){
        System.out.println(pre+" doSomeThings222222222's start.....");
        try {
            Thread.sleep(10+new Random().nextInt(3));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(pre+" doSomeThings222222222222's end!!!");
    }
}
