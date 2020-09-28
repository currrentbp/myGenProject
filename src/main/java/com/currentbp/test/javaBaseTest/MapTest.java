package com.currentbp.test.javaBaseTest;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;

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



    @Test
    public void t1(){
        Lists.newArrayList();
    }


    //==========================        测试方法中的实现方法          ===============================================================//
    public void putSomeKey() {
        Map<String, String> map = new HashMap<String, String>();
        System.out.println("size:" + map.size());

        map.put("123", "321");
        map.put("123", "3214");
        System.out.println("size:" + map.size());

        map.put("1234", "321");
        map.put("1234", "321");
        System.out.println("size:" + map.size());
        System.out.println(JSON.toJSONString(map));
    }

    public void getMapObjectStringFormat() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("123", "321");
        System.out.println(JSON.toJSONString(map));
    }

    /**
     * 测试获取一个不存在的key值时，返回的值
     */
    public void getValueByNotExitKey() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("123", "321");

        System.out.println("key:3,value:" + map.get("3"));

        Map<String, String> map2 = new HashMap<String, String>();

        System.out.println("key:3,value:" + map2.get("3"));
    }

    public void mapGetEachValue() {
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 100000; i++) {
            map.put("currentbp" + i, "baopan" + i);
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
    public void mapGetEachValue2() {
        Map<String, String> map = new HashMap<String, String>();

        for (int i = 0; i < 100000; i++) {
            map.put("currentbp" + i, "baopan" + i);
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
