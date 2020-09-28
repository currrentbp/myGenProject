package com.currentbp.test.System;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 测试拷贝问题
 *
 * @author baopan
 * @createTime 2020/7/21 12:39
 */
public class SystemCopyTest {

    @Test
    public void t1(){
        int [] source = new int[]{7,6,5,4,3,2,1};
        StringUtil.printObject(source);
        System.arraycopy(source,2,source,3,2);
        StringUtil.printObject(source);


    }
}
