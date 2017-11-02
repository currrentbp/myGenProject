package com.currentbp.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试代码，一个无法归类的。。。
 *
 * @author current_bp
 * @createTime 20161223
 */
public class Test1 {
    private final static Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void test11() {
        System.out.println("======");
    }

    @Test
    public void t1() {
        int count = 0;
        for (count++;
             count++ < 10;
             count++) {
            System.out.println("count:" + count);
        }
        System.out.println(count);
    }

    /**
     * 专门测试关于版本号的正则表达式
     */
    @Test
    public void zhengzeTest() {
        String zz = "^(\\d+\\.)*\\d+$";
        Pattern pattern = Pattern.compile(zz);
        Matcher matcher = pattern.matcher("1.1.1");
        Assert.assertTrue(matcher.find());
        Matcher matcher2 = pattern.matcher("1");
        Assert.assertTrue(matcher2.find());
        Matcher matcher3 = pattern.matcher("1.0");
        Assert.assertTrue(matcher3.find());
        Matcher matcher4 = pattern.matcher("1.2");
        Assert.assertTrue(matcher4.find());
        Matcher matcher5 = pattern.matcher("1.9");
        Assert.assertTrue(matcher5.find());

    }
}
