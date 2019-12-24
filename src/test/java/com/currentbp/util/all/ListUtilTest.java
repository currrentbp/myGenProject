package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author current_bp
 * @createTime 20170830
 */
public class ListUtilTest {


    private final static Logger logger = LoggerFactory.getLogger(ListUtilTest.class);


    @Test
    public void list2intArray() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);
        int[] ints = ListUtil.list2intArray(list);
        logger.info("===>"+JSON.toJSONString(ints));
    }

    @Test
    public void fill() throws Exception {
    }

    @Test
    public void fill1() throws Exception {
    }

    @Test
    public void sumNumsFromList() throws Exception {
    }

    @Test
    public void sumNumsFromArray() throws Exception {
    }

    @Test
    public void pureListWithoutNull() throws Exception {
    }

    @Test
    public void reverseList() throws Exception {
    }

    @Test
    public void stringList2IntegerList() throws Exception {
    }

    @Test
    public void stringList2LongList() throws Exception {
        String s1 = "1.0";
        String s2 = "2.0";
        System.out.println(s1.compareTo(s2));

        String s3 = "2.09";
        String s4 = "2.0";
        System.out.println(s3.compareTo(s4));

        String s5 = "2.0";
        String s6 = "2.0.1";
        System.out.println(s5.compareTo(s6));

        String s7 = "2.0.01";
        String s8 = "2.0.1";
        System.out.println(s7.compareTo(s8));
    }


}