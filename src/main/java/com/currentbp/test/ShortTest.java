package com.currentbp.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * short的测试类
 *
 * @author current_bp
 * @createTime 20170621
 */
public class ShortTest {
    private static Logger logger = LoggerFactory.getLogger(ShortTest.class);

    @Test
    public void shortAddInt() {
        short s1 = 1;
        //s1 = s1 + 1;//request:short found:int
        s1 += 1;
        logger.info("s1:" + s1);
    }
}
