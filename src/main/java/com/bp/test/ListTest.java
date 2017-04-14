package com.bp.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 专门用于列表的测试
 *
 * @author current_bp
 * @createTime 20170309
 */
public class ListTest {

    public static void main(String[] args) {
        ListTest listTest = new ListTest();


        //测试一个对象放入list中，在list中修改该对象的字段，看能否修改成功
//        listTest.object2ListAndChangeSome();

        //测试list的foreach的功能
//        listTest.listForMethod();
        listTest.listForMethod2();
    }


    /**
     *如果没有分隔符，则还是一个数组，只不过长度为1，
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
