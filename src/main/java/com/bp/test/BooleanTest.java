package com.bp.test;

/**
 * @author current_bp
 * @createTime 20170407
 */
public class BooleanTest {

    boolean flag1;


    /**
     * 证明：方法内的变量如果没有赋值，则无法获取默认值，类内的成员变量可以自动赋值
     1.成员变量可以被public，protect，private，static等修饰符修饰，而局部变量不能被控制修饰符及static修饰；两者都可以定义成final型
     2.成员变量存储在堆，局部变量存储在栈
     3.存在时间不同
     4.成员变量有默认值，（被final修饰且没有static的必须显式赋值），局部变量不会自动赋值
     */
    public void simpleTypeHasDefaultValue() {
        boolean flag;
        System.out.println("flag1:" + flag1);//编译通过，有默认值：false
//        System.out.println("flag:" + flag);//编译通不过
    }
}
