package com.currentbp.test.baseTypeTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author current_bp
 * @createTime 20170407
 */
public class BooleanTest {


    @Test
    public void diffBool(){
        String x = null;
        String y = "";
        System.out.println(x == null ^ y == null);
    }

    @Test
    public void t1(){
        List<Integer> t = null;
        for(Integer i: t){
            System.out.println(i);
        }


    }
    public static void main(String[] args) {
        int a = 10;
        assert a >9 :"baopan";
    }
    boolean flag1;


    public void eachOperatorResult() {
        boolean flagTrue = true;
        boolean flagFalse = false;

        System.out.println("true && true:" + (flagTrue && flagTrue));
        System.out.println("true && false:" + (flagTrue && flagFalse));
        System.out.println("false && false:" + (flagFalse && flagFalse));
        System.out.println("false && true:" + (flagFalse && flagTrue));
        System.out.println("=====================");
        System.out.println("true & true:" + (flagTrue & flagTrue));
        System.out.println("false & true:" + (flagFalse & flagTrue));
        System.out.println("true & false:" + (flagTrue & flagFalse));
        System.out.println("false & false:" + (flagFalse & flagFalse));
        System.out.println("======================");
        System.out.println("true ^ true:" + (flagTrue ^ flagTrue));
        System.out.println("true ^ false:" + (flagTrue ^ flagFalse));
        System.out.println("false ^ true:" + (flagFalse ^ flagTrue));
        System.out.println("false ^ false:" + (flagFalse ^ flagFalse));
        System.out.println("============================");
        System.out.println("!true:" + (!flagTrue));
        System.out.println("!false:" + (!flagFalse));

    }

    /**
     * 证明：方法内的变量如果没有赋值，则无法获取默认值，类内的成员变量可以自动赋值
     * 1.成员变量可以被public，protect，private，static等修饰符修饰，而局部变量不能被控制修饰符及static修饰；两者都可以定义成final型
     * 2.成员变量存储在堆，局部变量存储在栈
     * 3.存在时间不同
     * 4.成员变量有默认值，（被final修饰且没有static的必须显式赋值），局部变量不会自动赋值
     */
    public void simpleTypeHasDefaultValue() {
        boolean flag;
        System.out.println("flag1:" + flag1);//编译通过，有默认值：false
//        System.out.println("flag:" + flag);//编译通不过
    }
}
