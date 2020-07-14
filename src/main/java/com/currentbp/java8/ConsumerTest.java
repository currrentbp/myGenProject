package com.currentbp.java8;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author baopan
 * @createTime 2020/6/22 15:16
 */
public class ConsumerTest implements Serializable {

    @Test
    public void t4(){
        System.out.println(Integer.MAX_VALUE<<1);
        System.out.println(Integer.MAX_VALUE +"===="+(Integer.MAX_VALUE>>>1));
        System.out.println(Integer.MAX_VALUE<<1>>3);

    }


    final int x;

    public ConsumerTest (){
        x=1;
    }
    @Test
    public void t3(){
        System.out.println(x);
    }


    @Test
    public void t2(){
        new Thread(()->{

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int x = 10;
                    int y = 11;
                    System.out.println(x+y);
                }
            };

            runnable.run();

        }).start();
    }

    @Test
    public  void t1() {
        System.out.println((Integer.MAX_VALUE<<1)>>1);
        System.out.println(Integer.MAX_VALUE>>1);
        System.out.println((1) ^ (1 >>> 16));
//        testConsumer();
////        testAndThen();
//        testAndThen2();
        Object object = new Object();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(1,1);
        List<Integer> list3 = new Vector<>();

        Set<Integer> set = new HashSet<>();
        set.add(1);
        Set<Integer> set1 = new TreeSet<>();
        set1.add(2);
        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(3);


        char x = '包';
        System.out.println(x);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,23);
        map.remove(1);
        Map<Integer,Integer> map2 = new Hashtable<>();
        Map<Integer,Integer> map3 = new LinkedHashMap<>();
        Map<Integer,Integer> map4 = new TreeMap<>();
        map4.put(1,4);

        Map<Integer,Integer> map5 = new ConcurrentHashMap<>();
        map5.put(1,5);
    }

    /**
     * 一个简单的平方计算
     */
    public static void testConsumer(){
        Consumer<Integer> square = x -> System.out.println("print square : " + x * x);
        square.accept(2);
    }

    /**
     * 定义3个Consumer并按顺序进行调用andThen方法，其中consumer2抛出NullPointerException。
     */
    public static void testAndThen(){
        Consumer<Integer> consumer1 = x -> System.out.println("first x : " + x);
        Consumer<Integer> consumer2 = x -> {
            System.out.println("second x : " + x);
            throw new NullPointerException("throw exception test");
        };
        Consumer<Integer> consumer3 = x -> System.out.println("third x : " + x);

        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }

    public static void testAndThen2(){
        Consumer<Integer> consumer1 = x -> System.out.println("first x : " + x);
        Consumer<Integer> consumer2 = x -> {
            System.out.println("second x : " + x);
        };
        Consumer<Integer> consumer3 = x -> System.out.println("third x : " + x);

        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }
}
