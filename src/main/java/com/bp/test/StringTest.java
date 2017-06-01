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
    public void someFunctionEffection() {
        StringTest stringTest = new StringTest();


//		StringTest st = new StringTest();
//		st.isWin();

//		StringTest st = new StringTest();
//		st.sudu();
//		HashMap<String,String> map = new HashMap<String, String>();
//		//测试0是啥。。
//		String path="";
//		path = new String("abcdefABCDEF");
//		System.out.println(path.indexOf(41) );

//		//测试除数为0的这种情况
//		stringTest.isZero(10,0);

//		//测试数字和字符串的相等性问题
//		stringTest.isEqualWithEmpty();

//		//获取分割的字符串
//		stringTest.getSplitString();

        //判断1是否等于null
//		stringTest.equalsNull();

        //判读一个字符串中是否包含一个字符
//		stringTest.stringContain();

        //获取0到0的字符串
        stringTest.getZero2Zero();
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

    /**
     * 测试速度,没有测试成功
     * this.path.indexOf(0) < 0
     * path == null
     */
    public void sudu() {
        boolean flag = true;
        Long t1;
        Long t2;
        Long t3;
        Long t4;

        addL1AndL2();


        t1 = TimeUtil.currentTimeToLong();
        for (int i = 0; i < 1000000; i++) {
            flag = l1.get(i).indexOf(0) < 0;
        }
        t2 = TimeUtil.currentTimeToLong();
        System.out.println("time1:" + (t2 - t1));

        t3 = TimeUtil.currentTimeToLong();
        for (int i = 0; i < 1000000; i++) {
            flag = "".equals(l2.get(i));
        }
        t4 = TimeUtil.currentTimeToLong();
        System.out.println("time2:" + (t4 - t3));
    }

    public void addL1AndL2() {
        for (int i = 0; i < 1000000; i++) {
            if ((i & 2) == 0) {
                l1.add(i, "");
            } else {
                l1.add(i, "1");
            }
        }

        for (int i = 1; i < 1000001; i++) {
            if ((i & 2) == 0) {
                l2.add(i - 1, "");
            } else {
                l2.add(i - 1, "1");
            }
        }
    }



    /**
     * 测试split方法
     */
    public void stringSplit() {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        //预期大于 3，结果是 3
        System.out.println(ary.length);
        String str2 = "a.b.c..";
        String[] ary2 = str2.split(".");
        System.out.println(ary2.length);
        String str3 = "a.b.c..";
        String[] ary3 = str3.split("\\.");
        System.out.println(ary3.length);
    }

    /**
     * 获取分割的字符串
     */
    public void getSubString(String num) {
        String s1 = "_1";
        System.out.println(s1.split("_")[0]);
        String tail = num.substring(num.indexOf(".") + 1);
        String head = num.substring(0, num.indexOf("."));
        System.out.println("==" + head + "==" + tail + "==");
    }

    /**
     * 判断一个字符串赋值后，修改其中一个变量后的情况,
     * 结果证明：string 是final的，无法修改
     */
    public void twoStringChangeOneCharIsEqual() {
        String s1 = "123";
        String s2 = s1;
        System.out.println("s1:" + s1 + " == s2:" + s2 + " :" + s1.equals(s2));
        String s3 = s2.replace("2", "4");
        System.out.println("s1:" + s1 + " == s2:" + s2 + " :" + s1.equals(s2));
    }


    /**
     * 获取0到0的字符串:结果为空串
     */
    public void getZero2Zero() {
        String s1 = "1.2.3";
        System.out.println("=========" + s1.substring(0, 1) + "=========");
        System.out.println("".equals(s1.substring(0, 0)));
        System.out.println(s1.split("\\.")[2]);
        System.out.println((int) s1.charAt(0));
    }

    /**
     * 判读一个字符串中是否包含一个字符
     */
    public void stringContain() {
        System.out.println("1.1".contains("."));
        System.out.println("11".contains("."));
    }

    /**
     * 判断1是否等于null
     */
    @Test
    public void equalsNull() {
        System.out.println("1".equals(null));
    }

    /**
     * 获取分割的字符串
     */
    public void getSplitString() {
        String s1 = "baopan_1";
        System.out.println("before:" + s1.split("_")[0] + " after:" + s1.split("_")[1]);
    }


    /**
     * 测试常量的值是否相等
     */
    public void isEqualWithEmpty() {
        Integer x = 1;
        String s1 = "1";
        System.out.println("isEqual:" + s1.equals("" + x));
    }

    /**
     * 测试除数为0的这种情况
     *
     * @param read   被除数
     * @param totals 除数
     */
    public void isZero(int read, int totals) {
        System.out.println(String.format("%d", read * 100 / totals) + "%");
    }

    public void isWin() {
        String s = null;
        boolean flag = null != s & isok();
        System.out.println(flag);
    }

    public boolean isok() {
        System.out.println("====");
        return true;
    }
}
