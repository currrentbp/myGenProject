package com.currentbp.gc;

/**
 * 结果没有达到预期：希望能报错，打印出栈日志
 *
 * @author current_bp
 * @createTime 20180502
 */
public class PrintErrorStackInfo {

    Object obj1 = new Object();
    Object obj2 = new Object();

    public void fun1() {
        synchronized (obj1) {
            fun2();
        }
    }

    public void fun2() {
        synchronized (obj2) {
            while (true) { //为了演示需要，该函数永不退出
                System.out.println("ssssssfffffffffffssssssssssssssssssssssssssssssssssssssss");
            }
        }
    }

    public static void main(String[] args) {
        PrintErrorStackInfo aa = new PrintErrorStackInfo();
        aa.fun1();
    }
}
