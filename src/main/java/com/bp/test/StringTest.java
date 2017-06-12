package com.bp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bp.util.all.TimeUtil;
import org.junit.Test;


public class StringTest {


    public List<String> l1 = new ArrayList<String>();
    public List<String> l2 = new ArrayList<String>();

    //===================          测试方法          ========================================================//
    @Test
    //测试string、stringbuffer、stringbformat的效率问题
    public void someFunctionEffection() {
        for (int i = 0; i < 1000; i++) {
            compareEfficiencyWithStringAndStringBufferAndStringFormat(i);
        }


    }

    @Test
    public void stringFormatNullTest() {
        String s = null;
        System.out.println(String.format("ssss%fff", s));
    }


    //==========================        测试方法中的实现方法          ===============================================================//

    /**
     * 比较string stringbuffer stringformat等的效率
     * 结论证明：stringformat 最差，
     *
     String add：446ns
     StringBuilder add：447ns
     StringFormat：11156ns
     String add：2231ns
     StringBuilder add：446ns
     */
    public void compareEfficiencyWithStringAndStringBufferAndStringFormat(int i) {

        String success_code = "0";
        String splite = "bp";
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        String resultMsg2 = "";
        long time7 = System.nanoTime();
        resultMsg2 = "ErrorCode1=" + success_code + splite + "ErrorMsg1=心跳包接收成功" + i;
        long time8 = System.nanoTime();
        System.out.println("String add：" + (time8 - time7) + "ns");

        long time9 = System.nanoTime();
        sb2.append("ErrorCode2=").append(success_code).append(splite).append("ErrorMsg2=心跳包接收成功").append(i);
        long time10 = System.nanoTime();
        System.out.println("StringBuilder add：" + (time10 - time9) + "ns");

        String resultMsg = "";
        long time1 = System.nanoTime();
        String.format("ErrorCode=%s%sErrorMsg=心跳包接收成功%s", success_code, splite, i);
        long time2 = System.nanoTime();
        System.out.println("StringFormat：" + (time2 - time1) + "ns");

        long time3 = System.nanoTime();
        resultMsg = "ErrorCode=" + success_code + splite + "ErrorMsg=心跳包接收成功" + i;
        long time4 = System.nanoTime();
        System.out.println("String add：" + (time4 - time3) + "ns");

        long time5 = System.nanoTime();
        sb.append("ErrorCode=").append(success_code).append(splite).append("ErrorMsg=心跳包接收成功").append(i);
        long time6 = System.nanoTime();
        System.out.println("StringBuilder add：" + (time6 - time5) + "ns");
        System.out.println("-------------------------------------------------");
    }

}
