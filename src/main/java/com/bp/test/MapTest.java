package com.bp.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 关于map的测试
 *
 * @author current_bp
 * @createTime 20161111
 */
public class MapTest {

    public static void main(String[] args) {

//		MapTest.mapGetEachValue();
        MapTest.mapGetEachValue2();
    }

    public static void mapGetEachValue() {
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 100000; i++) {
            map.put("bp" + i, "baopan" + i);
        }

        Long time1 = System.currentTimeMillis();
        for (String key : map.keySet()) {
            System.out.println("key:" + key + " value:" + map.get(key));
        }
        Long time2 = System.currentTimeMillis();
        System.out.println("allTime:" + (time2 - time1));
        //count:10000,valueCount:8,avg:144.875,allResult:[153,118,117,207,91,110,95,268]
        //count:100000,valueCount:8,avg:989.5,allResult:[977,969,1002,1091,949,1116,956,856]


    }

    /**
     *
     */
    public static void mapGetEachValue2() {
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 100000; i++) {
            map.put("bp" + i, "baopan" + i);
        }

        Long time1 = System.currentTimeMillis();
        Iterator<String> iter = map.keySet().iterator();
        String key = null;

        while (iter.hasNext()) {
            key = iter.next();
            System.out.println("key:" + key + " value:" + map.get(key));
        }
        Long time2 = System.currentTimeMillis();
        System.out.println("allTime2:" + (time2 - time1));
        //count:10000,valueCount:8,avg:138.375,allResult:[129,132,83,128,256,106,105,168]
        //count:100000,valueCount:8,avg:965.875,allResult:[957,912,720,1116,958,977,1069,1018]

    }
}
