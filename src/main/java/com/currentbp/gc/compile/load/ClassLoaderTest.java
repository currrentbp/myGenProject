package com.currentbp.gc.compile.load;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author baopan
 * @createTime 20170907
 */
public class ClassLoaderTest {
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    /*
        不同的类加载器对instanceof关键字运算的结果的影响,
        它可以加载与自己在同一路径下的Class文件。 我们使用这个类加载器去加载了一个
    名为“com.currentbp.gc.compile.load.ClassLoaderTest”的类，并实例化了这个类的对象。 两行输出结
    果中，从第一句可以看出，这个对象确实是类com.currentbp.gc.compile.load.ClassLoaderTest实例化
    出来的对象，但从第二句可以发现，这个对象与类com.currentbp.gc.compile.load.ClassLoaderTest做
    所属类型检查的时候却返回了false，这是因为虚拟机中存在了两个ClassLoaderTest类，一个
    是由系统应用程序类加载器加载的，另外一个是由我们自定义的类加载器加载的，虽然都来
    自同一个Class文件，但依然是两个独立的类，做对象所属类型检查时结果自然为false。
         */
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("com.currentbp.gc.compile.load.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.currentbp.gc.compile.load.ClassLoaderTest);
    }
}
