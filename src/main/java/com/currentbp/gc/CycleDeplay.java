package com.currentbp.gc;

/**
 * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
 *
 * @author current_bp
 * @createTime 20170707
 */
public class CycleDeplay {


    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];


    public static void testGC() {
        CycleDeplay objA = new CycleDeplay();
        CycleDeplay objB = new CycleDeplay();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
//假设在这行发生GC,objA和objB是否能被回收？
        System.gc();
    }

    /**
     * 最后验证说明，没有任何效果。。。。。。验证失败。。。
     *
     * @param args
     */
    public static void main(String[] args) {
        CycleDeplay.testGC();
    }
}
