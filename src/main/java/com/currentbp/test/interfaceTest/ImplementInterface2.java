package com.currentbp.test.interfaceTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/10/13 19:50
 */
public class ImplementInterface2 implements ExtenseBaseInterface2 {

    @Override
    public String get2(int j) {
        return ""+j;
    }

    @Override
    public String get(int i) {
        return ""+i;
    }

    @Test
    public void t1(){
        ImplementInterface2 implementInterface = new ImplementInterface2();
        String s = implementInterface.get(1);
        System.out.println(s);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringUtil.printObject(stackTrace);
    }

    @Test
    public void t3(){
        String year = "1234";
        char c = year.charAt(2);
        String age = "" + c + "0后";
//        age="123";
        System.out.println("===>"+age);
    }
}
