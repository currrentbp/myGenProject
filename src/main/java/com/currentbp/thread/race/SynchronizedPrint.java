package com.currentbp.thread.race;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 使用synchronized作为同步的基础，按顺序打印字符
 * @author baopan
 * @createTime 20200423
 */
public class SynchronizedPrint {

    private static String c1 = "123456";
    private static String c2 = "ABCDEF";
    private static Object lock = new Object();
    public static void main(String[] args) {
        char[] chars1 = c1.toCharArray();
        char[] chars2 = c2.toCharArray();
        new Thread(()->{
            synchronized(lock){
                for (char c : chars1) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    }catch (Exception e){

                    }
                }
            lock.notify();//防止两个线程中的最后一个线程一直wait
            }
        }).start();
        new Thread(()->{
            synchronized(lock){
                for (char c : chars2) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    }catch (Exception e){

                    }
                }
            lock.notify();//防止两个线程中的最后一个线程一直wait
            }
        }).start();

    }

    @Test
    public void t1(){
        List<String> l1 = new ArrayList<>();
        l1.addAll(new ArrayList<>());
        System.out.println(l1.size());


        Integer i= Integer.parseInt("1245");
        Integer j= Integer.parseInt("1245");
        if(1245 == i) {
            System.out.println("===========");
        }else{
            System.out.println("+++++++++++");
        }
        if(i == j){
            System.out.println("jjjjjjjjjjjj");
        }else{
            System.out.println("ddddddddddd");
        }
    }

}
