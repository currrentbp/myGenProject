package com.currentbp.java8;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author baopan
 * @createTime 2020/6/22 15:16
 */
public class ConsumerTest implements Serializable {


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
        testConsumer();
//        testAndThen();
        testAndThen2();
        Object object = new Object();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(10,1);
        List<Integer> list3 = new Vector<>();

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();


        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map2 = new Hashtable<>();
        Map<Integer,Integer> map3 = new LinkedHashMap<>();
        Map<Integer,Integer> map4 = new TreeMap<>();
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
