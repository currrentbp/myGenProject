package com.bp.util.all.encryption;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * base64 的测试类
 *
 * @author current_bp
 * @createTime 20170719
 */
public class Bas64UtilTest {
    private final static Logger logger = LoggerFactory.getLogger(Bas64UtilTest.class);

    @Test
    public void decodeBase64() throws Exception {
        String source = Bas64Util.encodeBase64("bp");
        logger.info("===>source:" + source);
        String value = Bas64Util.decodeBase64(source);
        Assert.assertTrue(value.equals("bp"));
    }

    @Test
    public void encodeBase64() throws Exception {
    }

}