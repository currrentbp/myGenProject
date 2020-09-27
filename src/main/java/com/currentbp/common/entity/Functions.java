package com.currentbp.common.entity;

/**
 * @author baopan
 * @createTime 2020/9/26 18:08
 */
public class Functions {
    private Functions(){}

    public interface Function0<R>{
        R apply();
    }
    public interface Function1<R,F>{
        R apply(F f);
    }
    public interface Function2<R,F,S>{
        R apply(F f,S s);
    }
}
