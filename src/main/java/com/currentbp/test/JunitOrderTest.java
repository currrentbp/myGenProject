package com.currentbp.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

/**
 * 关于测试的顺序问题
 *
 * @author current_bp
 * @createTime 20171114
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class JunitOrderTest {
    private final static Logger logger = LoggerFactory.getLogger(JunitOrderTest.class);
    /*
    测试结果：只能按照名称从小到大，
     */
    @Test
    public void t1() throws InterruptedException {
        logger.info("===>t1");
        Thread.sleep(10*1000);
    }

    @Test
    public void t2(){
        logger.info("===>t2");
    }

    @Test
    public void t3(){
        logger.info("===>t3");
    }

    @Test
    public void t5(){
        logger.info("===>t5");
    }

    @Test
    public void t4(){
        logger.info("===>t4");
    }
}
