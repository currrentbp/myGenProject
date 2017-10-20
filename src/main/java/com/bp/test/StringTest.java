package com.bp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bp.util.all.TimeUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class StringTest {
    private final static Logger logger = LoggerFactory.getLogger(StringTest.class);

    public List<String> l1 = new ArrayList<String>();
    public List<String> l2 = new ArrayList<String>();

    //===================          测试方法          ========================================================//

    /**
     * 将一个字符串转换成计算公式，求出结果
     */
    @Test
    public void string2MathsGetValue(){
        try {
            String str = "a >= 0 && a <= 5";//"(a >= 0 && a <= 5)";
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put("a", -1);
            Object result = engine.eval(str);
            System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);

            String str2 = "Math.ceil(10.9)";//"43*(2 + 1.4)+2*32/(3-2.1)";
            ScriptEngineManager manager2 = new ScriptEngineManager();
            ScriptEngine engine2 = manager2.getEngineByName("js");
            Object result2 = engine2.eval(str2);
            System.out.println("结果类型:" + result2.getClass().getName() + ",计算结果:" + result2);
        }catch (Exception e){

        }
    }
    //测试格式化问题
    @Test
    public void stringFormat(){
        int i = 1;
        StringBuilder sb = new StringBuilder(11);
        sb.append("JCZB")
                .append(String.format("%02d", 1))
                .append(String.format("%03d", 2));
        logger.info("===>sb:"+sb.toString());
    }
    @Test
    //测试stringBuild有内容数时，超过时怎么样
    //结果：构造一个不带任何字符的字符串生成器，其初始容量由 capacity 参数指定。
    public void stringBuildHasCan(){
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append("12345");
        logger.info("===>sb:"+stringBuilder.toString());
    }
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
