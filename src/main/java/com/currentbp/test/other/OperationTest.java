package com.currentbp.test.other;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 操作符测试类
 *
 * @author current_bp
 * @createTime 20170601
 */
public class OperationTest {
    private static Logger logger = LoggerFactory.getLogger(OperationTest.class);
    @Test
    public void shortAnd() {
        int i = 10, j = 6;
        logger.info("i&j:" + (i & j));
    }

    @Test
    public void leftRun() {
        logger.info("===>  1 << 30 :" + ((int) (1 << 30)));//1073741824
        //移动31位时：-2147483648
    }

}
