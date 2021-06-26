package com.currentbp.test.other;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author baopan
 * @createTime 20210623
 */
public class TimeTest {
    public static final ZoneOffset BEIJING_ZONE_OFFSET = ZoneOffset.of("+8");
    @Test
    public void t1(){
        Date date = new Date();
        LocalDateTime endDateTime = new Date(date.getTime()).toInstant().atOffset(BEIJING_ZONE_OFFSET).toLocalDateTime();
        Date date2 = new Date(endDateTime.toInstant(BEIJING_ZONE_OFFSET).toEpochMilli());
        String format2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(date2);//yyyyMMddHHmmsss

        System.out.println("foramt2:"+format2);
        System.out.println("hour:"+endDateTime.getHour()+" min:"+endDateTime.getMinute());

        LocalDateTime endHourTime = endDateTime.withMinute((endDateTime.getMinute()/10) * 10).withSecond(0);
        System.out.println("hour:"+endHourTime.getHour()+" min:"+endHourTime.getMinute());
//        System.out.println(endHourTime.format(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss")));

        Date date1 = new Date(endHourTime.toInstant(BEIJING_ZONE_OFFSET).toEpochMilli());
        String format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(date1);//yyyyMMddHHmmsss
        System.out.println("foramt:"+format);
    }

    @Test
    public void t2(){
        Date date = new Date();
        Date date1 = new Date((date.getTime() / (10 * 60 * 1000)) * (10 * 60 * 1000));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        String format1 = simpleDateFormat.format(date1);//yyyyMMddHHmmsss
        System.out.println("format:"+format+" format1:"+format1);
    }
}
