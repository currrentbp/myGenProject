package com.currentbp.test.baseTypeTest;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 专门用于列表的测试
 *
 * @author current_bp
 * @createTime 20170309
 */
public class ListTest {
    private static Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void listRemove(){
        List<Integer> integers = Lists.newArrayList(1,2,3,0);
        integers.remove(Integer.valueOf(0));
        integers.remove(0);
        System.out.println(integers.toString());
    }

    @Test
    public void testGetSize() {
        List<Integer> source = new ArrayList<>(100000000);
        for (int i = 0; i < 50000000; i++) {
            source.add(i + 1);
        }
//        for (int j = 0; j < 20; j++) {
//
//            long start1 = System.currentTimeMillis();
//            for (int i = 0; i < source.size(); i++) {
//                Integer k = source.get(i);
//            }
//            long end1 = System.currentTimeMillis();
//
//            long start2 = System.currentTimeMillis();
//            int size = source.size();
//            for (int i = 0; i < size; i++) {
//                Integer k = source.get(i);
//            }
//            long end2 = System.currentTimeMillis();
//
//            System.out.println("time:" + (j + 1) + " used time1:" + (end1 - start1) + " time2:" + (end2 - start2));
//        }

        for (int j = 0; j < 20; j++) {

            long start1 = System.currentTimeMillis();
            int temp = 0;
            for (int i = 0; i < source.size(); i++) {
                temp = source.get(i);
            }
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            int size = source.size();
            for (int i = 0; i < size; i++) {
                temp = source.get(i);
            }
            long end2 = System.currentTimeMillis();

            System.out.println("time:" + (j + 1) + " used time1:" + (end1 - start1) + " time2:" + (end2 - start2));
        }

    }


    @Test
    public void t1() {


        //测试一个对象放入list中，在list中修改该对象的字段，看能否修改成功
//        listTest.object2ListAndChangeSome();

        //测试list的foreach的功能
//        listTest.listForMethod();
        listForMethod2();
    }

    @Test
    public void anyWhereAdd() {
//        List<String> list = new ArrayList<String>();
//        //由于初始化时没有设定数组大小，故会报错
//        list.add(10,"10");//报错：java.lang.IndexOutOfBoundsException: Index: 10, Size: 0
//        logger.info("10:"+list.get(10));


        List<String> list2 = new ArrayList<String>(22);
        //虽然设定了初始化数组的长度是22，但是，arraylist中的size没有改变，在add时，会判断size
        list2.add(10, "10");//java.lang.IndexOutOfBoundsException: Index: 10, Size: 0
        logger.info("10:" + list2.get(10));
    }

    @Test
    public void list2Set() {
        List<String> list = new ArrayList<String>();
        list.add("baopan");
        list.add("currentbp");
        list.add("baopan");
        list.add("bp1");
        logger.info("===>list:" + JSON.toJSONString(list));
        Set<String> set = new HashSet<String>(list);
        logger.info("===>set:" + JSON.toJSONString(set));
    }


    //==================  测试主要方法  =======================================================================//

    public void listRemoveOneGetSize() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println("===>befor: size:" + list.size() + " list:" + JSON.toJSONString(list));
        list.remove(2);
        System.out.println("===>after: size:" + list.size() + " list:" + JSON.toJSONString(list));
    }


    /**
     * 如果没有分隔符，则还是一个数组，只不过长度为1，
     * 如果后面是光秃秃的分隔符，则忽略这些分隔符
     */
    public void stringSplitToArray() {
        String s = "1,,";
        String[] array = s.split(",");
        System.out.println("array:" + JSON.toJSONString(array));
    }


    /**
     * 测试list的foreach的功能
     */
    public void listForMethod() {
        List<String> list = null;

        for (String s : list) {
            System.out.println("s:" + s);
        }
    }

    /**
     * 测试list的foreach的功能
     */
    public void listForMethod2() {
        List<String> list = new ArrayList<String>();

        for (String s : list) {
            System.out.println("s:" + s);
        }
    }


    /**
     * 测试一个对象放入list中，在list中修改该对象的字段，看能否修改成功
     */
    public void object2ListAndChangeSome() {
        TestListObject testListObject = new TestListObject();
        testListObject.setX(10);
        testListObject.setY(20);

        List<TestListObject> testListObjects = new ArrayList<TestListObject>();
        testListObjects.add(testListObject);

        testListObjects.get(0).setY(100);
        testListObjects.get(0).setX(222);

        System.out.println(JSON.toJSONString(testListObjects));
        System.out.println(JSON.toJSONString(testListObject));


    }


}

class TestListObject {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
