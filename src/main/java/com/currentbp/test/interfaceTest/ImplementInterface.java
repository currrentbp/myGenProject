package com.currentbp.test.interfaceTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/10/13 19:50
 */
public class ImplementInterface implements ExtenseBaseInterface {

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
        ImplementInterface implementInterface = new ImplementInterface();
        String s = implementInterface.get(1);
        System.out.println(s);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringUtil.printObject(stackTrace);
    }
}
