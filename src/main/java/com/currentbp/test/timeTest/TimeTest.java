package com.currentbp.test.timeTest;

import com.currentbp.util.all.TimeUtil;
import org.junit.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

    @Test
    public void between(){
        String region = "US";//America/New_York

        LocalDateTime localDateTime = LocalDateTime
                .ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("America/New_York"));
        Long startTime = 20221116182400L;
        long yyyyMMdd = startTime / 1000000;
        int dd = (int) yyyyMMdd % 100;
        int MM = (int) (yyyyMMdd / 100) % 100;
        int yyyy = (int) yyyyMMdd / 10000;
        LocalDateTime startDay = LocalDateTime.of(yyyy, MM, dd, 0, 0)
                .atZone(ZoneId.of("America/New_York")).toLocalDateTime();
        System.out.println( (int) Duration.between(startDay, localDateTime).toDays());
    }

    @Test
    public void getDiffZoneTime(){
        System.out.println(System.currentTimeMillis());
        LocalDateTime localDateTime = LocalDateTime.now()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime localDateTime2 = LocalDateTime.now()
                .atZone(ZoneId.of("UTC+8"))
                .toLocalDateTime();
        LocalDateTime localDateTime3 = LocalDateTime.now()
                .atZone(ZoneId.of("UTC-8"))
                .toLocalDateTime();
        System.out.println(localDateTime.toString());
        System.out.println(localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(localDateTime2.atZone(ZoneId.of("UTC+8")).toString());
        System.out.println(localDateTime2.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(localDateTime3.atZone(ZoneId.of("UTC-8")).toString());
        System.out.println(localDateTime3.toInstant(ZoneOffset.UTC).toEpochMilli());
    }

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
