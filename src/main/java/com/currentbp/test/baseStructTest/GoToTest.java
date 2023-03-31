package com.currentbp.test.baseStructTest;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/3/27 19:00
 */
public class GoToTest {

    @Test
    public void t3() {
        System.out.println(t3_1());
    }

    private int t3_1(){
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
            System.out.println("finally,x:"+x);
        }
    }

    @Test
    public void t2() {
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        System.out.println(s2 == "ab");
        System.out.println(s3 == "ab");
    }

    @Test
    public void t1() {
        String s = String.valueOf("1");
        StringBuffer stringBuffer = new StringBuffer("111");
        StringBuffer stringBuffer2 = new StringBuffer("111");
        StringBuilder stringBuilder = new StringBuilder("111");
        System.out.println(stringBuffer.toString().equals(stringBuilder.toString()));
        System.out.println(stringBuffer.equals(stringBuffer2));
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (j * i == 2) {
                    System.out.println("special: i:" + i + " j:" + j);
                    break ok;//可以跳出整体循环体
                } else {
                    System.out.println("i:" + i + " j:" + j);
                }
            }
            System.out.println("i:" + i);
        }


    }
}
