package com.currentbp.util.all;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author baopan
 * @createTime 20190729
 */
public class CheckUtilTest {

    @Test
    public void isChinese(){
//        Assert.isTrue(CheckUtil.isChinese(""),"error");
//        Assert.isTrue(CheckUtil.isChinese(null),"error");
//        Assert.isTrue(CheckUtil.isChinese("1"),"error");
//        Assert.isTrue(CheckUtil.isChinese("b"),"error");
        Assert.isTrue(CheckUtil.isChinese("包盼"),"error");
    }

}