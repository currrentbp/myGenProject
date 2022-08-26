package com.currentbp.test.timeTest;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TimeTest {

    @Test
    public void getHour() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hours1 = date.getHours();
        int minutes1 = date.getMinutes();
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        System.out.println(hours + "  " + hours1 + " " + minutes + " " + minutes1);
    }

    @Test
    public void testWeeks() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        int week2 = cal.get(Calendar.DAY_OF_WEEK) - 1 == 0 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(week + " " + week2);
    }

    @Test
    public void t1() {

    }
}
