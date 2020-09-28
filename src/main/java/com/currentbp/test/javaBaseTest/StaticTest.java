package com.currentbp.test.javaBaseTest;

/**
 * @author current_bp
 * @createTime 20170406
 */
public class StaticTest {

    public static int x=1;


    /**
     * 从对象中获取static变量和从class中直接获取static变量没有区别
     */
    public static void diffFromObject2Class(){
        System.out.println("StaticTest.x:"+StaticTest.x);
        StaticTest.x++;
        StaticTest staticTest1 = new StaticTest();
        System.out.println("staticTest1.x:"+staticTest1.x);
        staticTest1.x++;
        StaticTest staticTest2 = new StaticTest();
        System.out.println("staticTest2.x:"+staticTest2.x);
    }
}
