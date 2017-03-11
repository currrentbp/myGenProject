package com.bp.util.all;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by issuser on 2017/3/16.
 */
public class MathUtilTest {
    private MathUtil mathUtil = new MathUtil();


    @Test
    public void divideTwo() throws Exception {

    }

    @Test
    public void divideTwo1() throws Exception {

    }

    @Test
    public void multTwo() throws Exception {

    }

    @Test
    public void multTwo1() throws Exception {

    }

    @Test
    public void distanceFromTwoPlace() throws Exception {

    }

    @Test
    public void distanceFromTwoPlace1() throws Exception {

    }

    @Test
    public void allSubmultiple() throws Exception {

    }

    @Test
    public void maxCommonDivisor() throws Exception {

    }


    @Test
    public void addTwoLongNum1() throws Exception {

    }

    @Test
    public void addTwoLongNum(){
        //计算两个超长的数字相加的结果
        System.out.println("0+0 = "+MathUtil.addTwoLongNum("0", "0"));
        System.out.println("9.9+1.1 = "+MathUtil.addTwoLongNum("9.9", "1.1"));
        System.out.println("9999999999.9+1.11111 = "+MathUtil.addTwoLongNum("9999999999.9", "1.11111"));
        System.out.println("1234567890+987654321 = "+MathUtil.addTwoLongNum("1234567890", "987654321"));
        System.out.println("1000000.000001+1.1 = "+MathUtil.addTwoLongNum("1000000.000001", "1.1"));
    }

    @Test
    public void multTwoLongNum(){
//        System.out.println("1*1="+MathUtil.multTwoLongNum("1","1"));
//        System.out.println("1.0*1.0="+MathUtil.multTwoLongNum("1.0","1.0"));
//        System.out.println("1*1.0="+MathUtil.multTwoLongNum("1","1.0"));
//        System.out.println("2*5="+MathUtil.multTwoLongNum("2","5"));
//        System.out.println("2.0*5.0="+MathUtil.multTwoLongNum("2.0","5.0"));
//        System.out.println("20*50="+MathUtil.multTwoLongNum("20","50"));
//        System.out.println("100*50="+MathUtil.multTwoLongNum("100","50"));
        System.out.println("100*50.5="+MathUtil.multTwoLongNum("100","50.5"));
        System.out.println("100*50.555="+MathUtil.multTwoLongNum("100","50.555"));
        System.out.println("100*50.555="+MathUtil.multTwoLongNum("200","50.005"));

    }

}