package com.currentbp.jvm.initClassOrder;

/**
 * @author baopan
 * @createTime 2020/7/13 16:17
 */
public class InitOrder3 {
    public static void main(String[] args)throws  Exception{
        System.out.println(ConstClass.HELLO);
        //输出 hello
    }
}
/**
 * jdk:1.8
 * 常量在编译阶段会存入调用类的常量池，
 * 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 */
class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }
    public static  final String HELLO = "hello";
}
