package com.currentbp.test.reflection.loader;

/**
 * @author baopan
 * @createTime 2023-06-16 08:38:46
 */
public class MyClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(MyClassLoaderTest.class.getClassLoader().toString());//sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader.toString());//sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1.toString());//sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(classLoader2.toString());//sun.misc.Launcher$ExtClassLoader@6e5e91e4
        //bootstrapClassLoader是看不到的，因为这个加载器是C++实现的
    }
}
