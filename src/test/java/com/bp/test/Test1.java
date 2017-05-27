package com.bp.test;

import org.junit.Test;

/**
 * Created by issuser on 2016/12/23.
 */
public class Test1 {


    @Test
    public void test11(){
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
}
