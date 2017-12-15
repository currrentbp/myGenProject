package com.currentbp.gc.javaClass;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author current_bp
 * @createTime 20171215
 */
public class ClassTest {
    private final static Logger logger = LoggerFactory.getLogger(ClassTest.class);

    @Test
    public void t1() {
        ClassTest cls = new ClassTest();
        Class c = cls.getClass();
        logger.info("" + c);

        Object obj = new A();
        B b1 = new B();
        b1.show();

        // casts object
        A a = new A();
        a = A.class.cast(b1);

        logger.info("" + obj.getClass());
        logger.info("" + b1.getClass());
        //核心为：a = A.class.cast(b1); 把a转化为了B类型，此处容易产生把b1转成A类型误解。
        //此方法只能转换当前类型或其子类下的对象，只是简单进行强转。
        logger.info("" + a.getClass());
    }
}

class A {
    private final static Logger logger = LoggerFactory.getLogger(ClassTest.class);
    public static void show() {
        logger.info("Class A show() function");
    }
}

class B extends A {
    private final static Logger logger = LoggerFactory.getLogger(ClassTest.class);
    public static void show() {
        logger.info("Class B show() function");
    }
}