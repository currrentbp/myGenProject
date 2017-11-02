package com.currentbp.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 关于构造函数的测试类
 *
 * @author current_bp
 * @createTime 20170621
 */
public class ConstructorTest {
    private static Logger logger = LoggerFactory.getLogger(ConstructorTest.class);

    /*
    在外部类中使用构造方法时，编译报错
     */
    private ConstructorTest() {
        logger.info("===========");
    }

    public static void main(String[] args) {
        ConstructorTest constructorTest = new ConstructorTest();

    }
}
