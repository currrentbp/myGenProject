package com.currentbp.test;

import com.currentbp.test.javaBaseTest.TimeTest;
import org.junit.Test;

/**
 * Created by issuser on 2017/3/20.
 */
public class TimeTestTest {
    private TimeTest timeTest = new TimeTest();
    @Test
    public void printNowTimeLong() throws Exception {

    }

    @Test
    public void printSomeTimeLong() throws Exception {

    }

    @Test
    public void getTimeByLong(){
        timeTest.getTimeByLong();
        System.out.println("=====");
    }

}