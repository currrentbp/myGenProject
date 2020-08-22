package com.currentbp.test.initClass;

/**
 * @author baopan
 * @createTime 2020/8/12 21:29
 */
public class ClassInitializationTest2 {
    public static void main(String args[]) throws InterruptedException {

        //accessing static field of Parent through child, should only initialize Parent
        System.out.println(Child2.familyName);
    }
}

class Parent2 {
    //compile time constant, accessing this will not trigger class initialization
    //protected static final String familyName = "Lawson";

    protected static String familyName = "Lawson";

    static { System.out.println("static block of Super class is initialized"); }
    {System.out.println("non static blocks in super class is initialized");}
}

class Child2 extends Parent2 {
    protected static  String familyName = "Lawson";
    static { System.out.println("static block of Sub class is initialized in Java "); }
    {System.out.println("non static blocks in sub class is initialized");}
}
/*
分析：
这里的初始化发生是因为有静态域被访问，而且不一个编译时常量。
如果声明的”familyName”是使用final关键字修饰的编译时常量使用
（就是上面的注释代码块部分）超类的初始化就不会发生。
尽管静态与被子类所引用但是也仅仅是超类被初始化
 */

