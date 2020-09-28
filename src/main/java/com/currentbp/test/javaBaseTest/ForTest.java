package com.currentbp.test.javaBaseTest;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 20190819
 */
public class ForTest {

    @Test
    public void forBreak(){
        List<Integer> intes = Lists.newArrayList(1,2,3,4);
        intes.forEach(i->{
            if(i==2){
                System.out.println("this is 2");
                return;
            }
            System.out.println("i:"+i);
        });

    }

    @Test
    public void t1() {
        int size = 256;
//        List<String> s = new ArrayList<>();
//        s.add("f");
//        s.forEach(k->System.out.println(k));
        //第一种耗时比较短，
        for1(size);
        //第二种耗时长
        forEach(size);

    }

    @Test
    public void t2() {
        test(256);
    }

    private void forEach(int size) {
        Map<String, String> map = init(size);

        List<String> order = order(size);
//        get1(order, map);
        long start = System.currentTimeMillis();
        order.forEach(o -> map.get(o));
        long end = System.currentTimeMillis();
        System.out.println("time2:" + (end - start));
    }

    private void get1(List<String> order, Map<String, String> map) {
        long start = System.currentTimeMillis();
        order.forEach(o -> map.get(o));
        long end = System.currentTimeMillis();
        System.out.println("time2:" + (end - start));
    }

    private void for1(int size) {
        Map<String, String> map = init(size);
        List<String> order = order(size);

        get2(map,order);
    }
    private void get2( Map<String, String> map ,List<String> order){
        long start = System.currentTimeMillis();
        for (String key : order) {
            String value = map.get(key);
        }
        long end = System.currentTimeMillis();
        System.out.println("time1:" + (end - start));
    }

    private List<String> order(int size) {
        List<String> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(Integer.toString(new Random().nextInt(size) + 1));
        }
        return result;
    }

    private Map<String, String> init(int size) {
        Map<String, String> result = new HashMap<>(size);

        for (int i = 0; i < size; i++) {
            result.put(Integer.toString(i), Integer.toString(new Random().nextInt(10)));
        }
        return result;
    }



    private static void test(int num) {
        Map<String, String> map = new HashMap<>(num);
        List<String> list = new ArrayList(num);
        for (int i = 0; i < num; i++) {
            list.add(String.valueOf((int) (Math.random() * (num + 1))));
            map.put(String.valueOf(i), String.valueOf(Math.random()));
        }
        method1(list, map, "1");
        method1(list, map, "2");
        method1(list, map, "3");
        return;
    }

    private static void method1(List<String> list, Map<String, String> map, String desc) {
        long time1 = System.currentTimeMillis();
        list.forEach(key -> map.get(key));
        long time2 = System.currentTimeMillis();
        System.out.println(desc + "----" + (time2 - time1));
        long time3 = System.currentTimeMillis();
        for (String key : list)
            map.get(key);
        long time4 = System.currentTimeMillis();
        System.out.println(desc + "----" + (time4 - time3));
    }

}
