package com.currentbp.jvm.initClassOrder;

/**类的初始化动作
 * @author baopan
 * @createTime 2020/7/13 16:12
 */
public class InitOrder1 {
    public static void main(String[] args)throws  Exception{
        System.out.println(SubClass.value);
        //输出:
        //SuperClass init!
        //123
    }
}
/**
 * jdk:1.8
 * 通过子类引用父类的静态字段,不会导致子类初始化
 */
class  SuperClass{
    static {
        System.out.println("SuperClass init!");
    }
    public  static  int value=123;
}
class  SubClass extends  SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}