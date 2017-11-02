package com.currentbp.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试一下junit在两个构造函数的类中能否执行
 *
 * @author currrent_bp
 * @createTime 20170612
 */
public class JunitTest {
    private final static Logger logger = LoggerFactory.getLogger(JunitTest.class);

    public JunitTest() {
        logger.info("===> no params!!");
    }
//    public JunitTest(int i){
//        logger.info("===> one param: i:"+i);
//    }

    /**
     * 测试结果：不能超过两个构造函数
     */
    @Test
    public void t1() {
        logger.info("======================");
    }
}
