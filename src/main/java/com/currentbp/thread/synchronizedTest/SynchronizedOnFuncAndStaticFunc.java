package com.currentbp.thread.synchronizedTest;

import java.util.Random;

/**
 * @author baopan
 * @createTime 2020/8/11 21:11
 */
public class SynchronizedOnFuncAndStaticFunc {

    public static void main(String[] args) {
        SynchronizedOnFuncAndStaticFunc s1 = new SynchronizedOnFuncAndStaticFunc();
        new Thread(()->{
            for(int i=0;i<5;i++){
                s1.doSomeThings("===>");
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<5;i++){
                SynchronizedOnFuncAndStaticFunc.doSomeThings2("+++>");
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

    public static synchronized void doSomeThings2(String pre){
        System.out.println(pre+" doSomeThings222222222's start.....");
        try {
            Thread.sleep(10+new Random().nextInt(3));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(pre+" doSomeThings222222222222's end!!!");
    }
}
