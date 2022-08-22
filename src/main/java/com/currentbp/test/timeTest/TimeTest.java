package com.currentbp.test.timeTest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TimeTest {

    @Test
    public void testWeeks(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);
    }
    @Test
    public void t1(){

    }
}
