package com.currentbp.util.all;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间util的测试类
 *
 * @author current_bp
 * @createTime 20170420
 */
public class TimeUtilTest {
    private final static Logger logger = LoggerFactory.getLogger(TimeUtilTest.class);

    private TimeUtil timeUtil = new TimeUtil();

    @Test
    public void currentTimePrecise() {

    }

    @Test
    public void currentTimeByFormat() {

    }

    @Test
    public void currentTimeToLong() {

    }

    @Test
    public void getSpecialTime2Long() {

    }

    @Test
    public void getYueOrDayByFormat() {

    }

    @Test
    public void getYueOrDayByFormat1() {

    }

    @Test
    public void getYueOrDayByFormat2() {

    }

    @Test
    public void getBeforeMonth() {

    }

    @Test
    public void getBeforeMonth1() {

    }

    @Test
    public void getWeekOfDate() {

    }

    @Test
    public void getWeekOfDate1() {

    }

    @Test
    public void getWeekOfDate2() {

    }

    @Test
    public void getWeekOfDate11() {

    }

    @Test
    public void getDateByLong() {
        //获取时间通过long
        Long time1 = 0L;
        System.out.println(new Date(time1));
    }

    @Test
    public void getCurrentYear() throws Exception {
        Integer currentYear = TimeUtil.getCurrentYear();
        logger.info("===>" + currentYear);
    }

    @Test
    public void getCurrentMonth() throws Exception {
        Integer currentMonth = TimeUtil.getCurrentMonth();
        logger.info("===>" + currentMonth);
    }

    @Test
    public void getCurrentDay() throws Exception {
        Integer currentDay = TimeUtil.getCurrentDay();
        logger.info("===>" + currentDay);
    }

    @Test
    public void t1() throws ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(s.parse("2021-04-14 20:51:30:111"));
    }

    @Test
    public void t3(){
        String currentTime = TimeUtil.currentTime("yyyyMMddHHmmss");
        String minute = currentTime.substring(0, 12);
        String secondsStr = currentTime.substring(12);
        int seconds = Integer.parseInt(secondsStr);

        System.out.println( minute + (seconds >= 30 ? "30" : "00"));
    }


}