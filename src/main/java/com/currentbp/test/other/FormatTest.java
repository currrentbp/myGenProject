package com.currentbp.test.other;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/10/10 10:54
 */
public class FormatTest {
    @Test
    public void t1(){
        String format = String.format("{%s}:%s", "bapoan", "xxxxxx");
        System.out.println(format);
    }
}
