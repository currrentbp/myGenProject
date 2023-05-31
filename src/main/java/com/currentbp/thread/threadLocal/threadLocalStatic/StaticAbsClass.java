package com.currentbp.thread.threadLocal.threadLocalStatic;

/**
 * @author baopan
 * @createTime 2023/5/21 21:49
 */
public abstract class StaticAbsClass {
    private static final ThreadLocal<String> tl = new ThreadLocal<>();


    public static void setTl(String k1){
        tl.set(k1);
    }

    public static String getTl(){
        return tl.get();
    }
}
