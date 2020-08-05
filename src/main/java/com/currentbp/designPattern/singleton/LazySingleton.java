package com.currentbp.designPattern.singleton;

/**
 * 懒汉式单例
 * 懒汉式的方式就是，一开始比较懒，不去创建对象，
 * 等到程序需要我的时候，实在没法再拖了，就只能创建对象了
 *
 * @author baopan
 * @createTime 2020/8/2 10:30
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    public LazySingleton() {
    }

    //此处使用了双锁机制
    public LazySingleton getInstance() {
        if (null == lazySingleton) {
            synchronized (LazySingleton.class) {
                if (null == lazySingleton) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
