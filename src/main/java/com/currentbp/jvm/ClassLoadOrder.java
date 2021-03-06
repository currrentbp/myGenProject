package com.currentbp.jvm;

/**
 * 程序加载顺序
 * @author baopan
 * @createTime 20181010
 */
public class ClassLoadOrder {

    public static void main(String[] args) {
        staticFunction();
    }

    static ClassLoadOrder st = new ClassLoadOrder();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    ClassLoadOrder() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;

}
