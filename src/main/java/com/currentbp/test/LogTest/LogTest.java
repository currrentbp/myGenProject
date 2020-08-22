package com.currentbp.test.LogTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author baopan
 * @createTime 2020/8/15 10:25
 */
public class LogTest {
    private final static Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        MDC.put("currentOperatorId", "" + 22222);
        logger.info("11111111111111");
        new Thread(() -> {
//            MDC.put("currentOperatorId", ""+444444);
            logger.info("3333333333");
        }).start();
        new Thread(() -> {
            MDC.put("currentOperatorId", "" + 666);
            logger.info("555555555555");
        }).start();
    }

    @Test
    public void t1() {
        MDC.put("currentOperatorId", "" + 22222);
        logger.info("11111111111111");
        new Thread(() -> {
//            MDC.put("currentOperatorId", ""+444444);
            logger.info("3333333333");
        }).start();
        new Thread(() -> {
            MDC.put("currentOperatorId", "" + 666);
            logger.info("5555");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
