package com.bp.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 关于runtime的相关测试
 *
 * @author current_bp
 * @createTime 20170623
 */
public class RunTimeTest {
    private static Logger logger = LoggerFactory.getLogger(RunTimeTest.class);

    /**
     * 获取可用处理器的数目
     */
    @Test
    public void availableProcessors() {
        logger.info("value:" + Runtime.getRuntime().availableProcessors());
    }
}
