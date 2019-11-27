package com.currentbp.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author current_bp
 * @createTime 20161130
 */
public class TimeTest {

    @Test
    public void t2() {
        System.out.println(getFormatTime("2018-12-1"));
    }

    private String getFormatTime(String time) {
        if (StringUtils.isBlank(time)) {
            return "";
        }
        SimpleDateFormat after = new SimpleDateFormat("MM月dd日");
        try {
            Date date = DateUtils.parseDate(time, "yyyy-MM-dd");
            return after.format(date);
        } catch (Exception e) {
        }
        return "";
    }


    @Test
    public void t1() {
        long currentTime = System.currentTimeMillis();
    }

    @Test
    public void formateTime2() {
        Date dd = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dd);
        c.add(4, 10);
        Date time = c.getTime();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(formater.format(time));
    }

    @Test
    public void formatTime() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日");
        String result = "缺货，预计" + formater.format(new Date(date.getTime() + 154 * 24 * 60 * 60 * 1000L)) + "到货";
        String target = new SimpleDateFormat("yyyy年").format(date);
        String replace = result.replace(target, "");
        System.out.println(replace);
    }

    public void getTimeByLong() {
        Long time = 1487845207000L;
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = simpleDateFormat.format(date);
        System.out.println(time1);
    }

    /**
     * 打印当前的时间
     */
    public void printNowTimeLong() {
        System.out.println("time:" + System.currentTimeMillis());
    }

    public void printSomeTimeLong() {
        Date d = new Date();

        d.setYear(2016 - 1900);
        d.setMonth(10);
        d.setDate(29);
        d.setHours(10);
        d.setMinutes(10);
        d.setSeconds(10);

        System.out.println(d.getTime());
    }


}
