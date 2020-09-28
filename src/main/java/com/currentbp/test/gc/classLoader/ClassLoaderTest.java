package com.currentbp.test.gc.classLoader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 关于加载器的测试
 *
 * @author current_bp
 * @createTime 20171211
 */
public class ClassLoaderTest {
    private final static Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);

    @Test
    public void commonBeanClassLoaer() {
        ClassLoader classLoader = new CommonBean().getClass().getClassLoader();
        logger.info("===>current classLoader:" + classLoader.toString());
        logger.info("===>current classLoader's father:" + classLoader.getParent().toString());
        ClassLoader parent = classLoader.getParent().getParent();//不存在其父加载器了
        logger.info("===>current classLoader's grandFather:" + parent.toString());
    }

    @Test
    public void intClassLoader() {
        ClassLoader classLoader = int.class.getClassLoader();//int.class是由Bootstrap ClassLoader加载的
        logger.info("===>int classLoader:" + classLoader.toString());
    }

    @Test
    public void customedDefindClassLoader() {
        DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");
        try {
            //加载class文件
            Class c = diskLoader.findClass("com.currentbp.test.gc.classLoader.CommonBean1");
            //===>customedDefindClassLoader: c:class com.currentbp.test.gc.classLoader.CommonBean1 c.ClassLoader:com.currentbp.test.gc.classLoader.DiskClassLoader@4ca21d88
            //表示：使用的是自定义的类加载器
            logger.info("===>customedDefindClassLoader: c:" + c + " c.ClassLoader:" + c.getClassLoader());

            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say", null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
