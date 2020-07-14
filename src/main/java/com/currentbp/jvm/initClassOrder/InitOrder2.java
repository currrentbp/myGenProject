package com.currentbp.jvm.initClassOrder;

/**
 * @author baopan
 * @createTime 2020/7/13 16:14
 */
public class InitOrder2 {
    public static void main(String[] args)throws  Exception{
        SuperClass2[] sca=new SuperClass2[10];
        //无输出
    }
}

/**
 * jdk：1.8
 * 通过数组定义来引用类，不会触发此类的初始化
 */
class  SuperClass2{
    static {
        System.out.println("SuperClass init!");
    }
    public  static  int value=123;
}
class  SubClass2 extends  SuperClass2{
    static {
        System.out.println("SubClass init!");
    }
}

