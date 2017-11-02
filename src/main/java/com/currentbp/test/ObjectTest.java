package com.currentbp.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author current_bp
 * @createTime 20170913
 */
public class ObjectTest {
    private final static Logger logger = LoggerFactory.getLogger(ObjectTest.class);


    /**
     * 关于复杂赋值问题
     */
    @Test
    public void objectRevalue() {
        Integer i = 1;
        Integer j = 2;
        Integer k = 3;
        k = j = i;
        logger.info("===>k:" + k + " j:" + j + " i:" + i);
    }
}
