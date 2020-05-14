package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by issuser on 2017/3/16.
 */
public class MathUtilTest {
    private final static Logger logger = LoggerFactory.getLogger(MathUtilTest.class);
    @Test
    public void combination() throws Exception {
        int[] source = {1,2,3,4,5};
        List<String> combination = MathUtil.combination(source, 3);
        logger.info(JSON.toJSONString(combination));
    }


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
    public void addTwoLongNum() {
        //计算两个超长的数字相加的结果
        System.out.println("0+0 = " + MathUtil.addTwoLongNum("0", "0"));
        System.out.println("9.9+1.1 = " + MathUtil.addTwoLongNum("9.9", "1.1"));
        System.out.println("9999999999.9+1.11111 = " + MathUtil.addTwoLongNum("9999999999.9", "1.11111"));
        System.out.println("1234567890+987654321 = " + MathUtil.addTwoLongNum("1234567890", "987654321"));
        System.out.println("1000000.000001+1.1 = " + MathUtil.addTwoLongNum("1000000.000001", "1.1"));
    }

    @Test
    public void multTwoLongNum() {
//        System.out.println("1*1="+MathUtil.multTwoLongNum("1","1"));
//        System.out.println("1.0*1.0="+MathUtil.multTwoLongNum("1.0","1.0"));
//        System.out.println("1*1.0="+MathUtil.multTwoLongNum("1","1.0"));
//        System.out.println("2*5="+MathUtil.multTwoLongNum("2","5"));
//        System.out.println("2.0*5.0="+MathUtil.multTwoLongNum("2.0","5.0"));
//        System.out.println("20*50="+MathUtil.multTwoLongNum("20","50"));
//        System.out.println("100*50="+MathUtil.multTwoLongNum("100","50"));
//        System.out.println("100*50.5=" + MathUtil.multTwoLongNum("100", "50.5"));
//        System.out.println("100*50.555=" + MathUtil.multTwoLongNum("100", "50.555"));
//        System.out.println("200*50.555=" + MathUtil.multTwoLongNum("200", "50.005"));
//        System.out.println("200*50.005=" + MathUtil.multTwoLongNum("200", "50.005"));
//        System.out.println("2.0*50000000000.00000000000005=" + MathUtil.multTwoLongNum("2.0", "50000000000.00000000000005"));
//        System.out.println("2.0*50000000000000000.000000000000000000000000005=" +
//                MathUtil.multTwoLongNum("2.0", "50000000000000000.000000000000000000000000005"));
//        System.out.println("1234567890*987654321=" + MathUtil.multTwoLongNum("1234567890", "987654321"));
//        System.out.println("0*0=" + MathUtil.multTwoLongNum("0", "0"));
//        System.out.println("0.0*0=" + MathUtil.multTwoLongNum("0.0", "0"));
//        System.out.println("0.0*0.0=" + MathUtil.multTwoLongNum("0.0", "0.0"));
//        System.out.println("9.0*0.9=" + MathUtil.multTwoLongNum("9.0", "0.9"));
//        System.out.println("9.99999*9999999.9=" + MathUtil.multTwoLongNum("9.99999", "9999999.9"));
        System.out.println("-5*-2.0=" + MathUtil.multTwoLongNum("-5", "-2.0"));
    }

    public void subTwoLonNum() {

        System.out.println("1-1 = " + MathUtil.subTwoLonNum("1", "1"));
        System.out.println("2-1.0 = " + MathUtil.subTwoLonNum("2", "1.0"));
        System.out.println("1.0-2 = " + MathUtil.subTwoLonNum("1.0", "2"));
        System.out.println("1.0-2.0 = " + MathUtil.subTwoLonNum("1.0", "2.0"));
        System.out.println("1.0-99.0 = " + MathUtil.subTwoLonNum("1.0", "99.0"));
        System.out.println("1-(-1) = " + MathUtil.subTwoLonNum("1", "-1"));
        System.out.println("-1-1 = " + MathUtil.subTwoLonNum("-1", "1"));
        System.out.println("1-(-1) = " + MathUtil.subTwoLonNum("1.0", "-1"));
        System.out.println("-1.0-1 = " + MathUtil.subTwoLonNum("-1.0", "1"));
    }

    @Test
    public void compoundInterest() {
        double result = MathUtil.compoundInterest(10000D, 0.1D, 30);
        StringUtil.printObject(result);
    }

    @Test
    public void c() {
    }

    @Test
    public void factorial() {
    }

    @Test
    public void factorial1() {
    }

    @Test
    public void subtractionTwoLongNum() {
        Double x = 0.000000000D;
        System.out.println(x!= 0D);
    }

    @Test
    public void compoundInterest2() {
        double result = MathUtil.compoundInterest2(1000D, 0.0058D, 10*30,4);
        StringUtil.printObject(result);//14182578
    }
}