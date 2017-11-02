package com.currentbp.util.all;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class PathUtilTest {
    private final static Logger logger = LoggerFactory.getLogger(PathUtilTest.class);


    @Test
    public void getLocalResourcePath() throws Exception {
        String localResourcePath = PathUtil.getMvnLocalResourcePath();
        Assert.notNull(localResourcePath, "path is null");
        logger.info("path:"+localResourcePath);

    }

    @Test
    public void getTailFromUrl() throws Exception {
        String tail = PathUtil.getTailFromUrl("http://www.baidu.com/baopan.html");
        logger.info(tail);
        Assert.notNull(tail,"is null");
    }

}