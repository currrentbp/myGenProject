package com.currentbp.test.javaBaseTest;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author baopan
 * @createTime 20211207
 */
public class PatternTest {

    Pattern pattern = Pattern.compile("[\\-_A-Za-z0-9\\u4e00-\\u9fa5\\\\*\\u0020/]*");

    @Test
    public void t1() {
        boolean matches = pattern.matcher("***啊1123呵呵大   //").matches();
        System.out.println(matches);
    }
}
