package com.bp.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by issuser on 2017/3/16.
 */
public class StringTestTest {

    private StringTest stringTest = new StringTest();


    @Test
    public void sudu() throws Exception {

    }

    @Test
    public void addL1AndL2() throws Exception {

    }

    @Test
    public void getZero2Zero() throws Exception {

    }

    @Test
    public void stringContain() throws Exception {

    }

    @Test
    public void equalsNull() throws Exception {

    }

    @Test
    public void getSplitString() throws Exception {

    }

    @Test
    public void isEqualWithEmpty() throws Exception {

    }

    @Test
    public void isZero() throws Exception {

    }

    @Test
    public void isWin() throws Exception {

    }

    @Test
    public void isok() throws Exception {

    }

    @Test
    public void twoStringChangeOneCharIsEqual() {
        stringTest.twoStringChangeOneCharIsEqual();
    }

    @Test
    public void getSubString() {
        stringTest.getSubString("1.2");
        stringTest.getSubString(".2");
        stringTest.getSubString("1.");
        stringTest.getSubString("1");
    }


    @Test
    public void stringSplit() {
        stringTest.stringSplit();
    }

    @Test
    public void compareEfficiencyWithStringAndStringBufferAndStringFormat() {
        for (int i = 0; i < 1000; i++) {
            stringTest.compareEfficiencyWithStringAndStringBufferAndStringFormat();
        }
    }

}