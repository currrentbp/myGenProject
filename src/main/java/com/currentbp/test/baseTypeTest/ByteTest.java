package com.currentbp.test.baseTypeTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * byte 测试
 *
 * @author current_bp
 * @createTime 20170623
 */
public class ByteTest {
    private static Logger logger = LoggerFactory.getLogger(ByteTest.class);


    @Test
    public void byte1() {
        byte[] bytes = new byte[1 << 30];//1<<31 会报错：NegativeArraySizeException
        logger.info("size;" + bytes.length);

    }
}
