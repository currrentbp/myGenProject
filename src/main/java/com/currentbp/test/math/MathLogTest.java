package com.currentbp.test.math;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210105
 */
public class MathLogTest {

    @Test
    public void t1(){
        System.out.println(Math.log10(5));
        System.out.println(((int)Math.floor(Math.log10(5))));
        String x = "2222"+"_"+null;
        System.out.println(x);
    }

}
