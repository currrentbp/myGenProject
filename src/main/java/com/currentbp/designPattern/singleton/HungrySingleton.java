package com.currentbp.designPattern.singleton;

/**
 * 优点：绝对线程安全
 * 缺点：可能造成内存浪费，当引用程序中
 * @author baopan
 * @createTime 2020/4/27 10:05
 */
public class HungrySingleton {
    private static  HungrySingleton instance = null;
    {
        instance = new HungrySingleton();
    }

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }
}
