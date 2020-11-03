package com.currentbp.util.all;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 关于时间的类。
 *
 * @author current_bp
 * @time 20160405
 */
public class TimeUtil {
    private static final TimeZone zone = TimeZone.getTimeZone("Asia/Shanghai");
    private final static ZoneOffset ZONE_OFFSET = ZoneOffset.ofHours(8);
    private static final Long dayMillis = 24L * 3600 * 1000;

    /**
     * 获取今天开始时间
     */
    public static Date getTodayZero() {
        return getDateZero(LocalDate.now(ZONE_OFFSET));
    }

    /**
     * 获取今天结束时间
     */
    public static Date getTodayEnd() {
        return getDateEnd(LocalDate.now(ZONE_OFFSET));
    }

    public static Date getDateZero(LocalDate localDate) {
        return Date.from(
                LocalDateTime.of(localDate, LocalTime.MIN)
                        .toInstant(ZONE_OFFSET));
    }

    public static Date getDateEnd(LocalDate localDate) {
        return Date.from(
                LocalDateTime.of(localDate, LocalTime.of(23, 59, 59, 0))
                        .toInstant(ZONE_OFFSET));
    }

    /**
     * 获取昨天的这个时间
     */
    public static String getYesterdayStr() {
        long now = System.currentTimeMillis();
        long yester = now - dayMillis;
        return DateFormatUtils.format(yester, "yyyyMMdd", zone);
    }

    /**
     * 获取当前年份
     *
     * @return 年份
     */
    public static Integer getCurrentYear() {
        Date d = new Date();
        return 1900 + d.getYear();
    }

    /**
     * 获取当前月份
     *
     * @return 月份
     */
    public static Integer getCurrentMonth() {
        Date d = new Date();
        return 1 + d.getMonth();
    }

    /**
     * 获取当前日
     *
     * @return 日
     */
    public static Integer getCurrentDay() {
        Date d = new Date();
        return d.getDate();
    }

    /**
     * 获得当前精确的时间，精确到毫秒。
     *
     * @return 当前时间
     */
    public static String currentTimePrecise() {
        String time;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        time = s.format(d);

        return time;
    }

    /**
     * 根据参数的格式输出当前时间。 格式：yyyy-MM-dd HH:mm:ss:SSS
     *
     * @param format 时间格式
     * @return 当前时间
     */
    public static String currentTimeByFormat(String format) {
        String time;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat(format);
        time = s.format(d);
        return time;
    }

    /**
     * 将当前时间转换成长的数字。
     *
     * @return 当前时间
     */
    public static Long currentTimeToLong() {
        return new Date().getTime();
    }

    /**
     * 查询给定时间的毫秒数
     *
     * @param year  年>=1900
     * @param month 月>=1
     * @param day   日>=1
     * @param hour  时>=1
     * @param min   分>=1
     * @param sec   秒:>=1
     * @return 给定时间的毫秒数
     */
    public static Long getSpecialTime2Long(int year, int month, int day, int hour, int min, int sec) {
//		year - 减 1900 的年份。
//		month - 0-11 之间的月份。
//		date - 一月中 1-31 之间的某一天。
//		hrs - 0-23 之间的小时数。
//		min - 0-59 之间的分钟数。
//		sec - 0-59 之间的秒数。
        return new Date(year - 1900, month - 1, day, hour - 1, min - 1, sec - 1).getTime();
    }


    /**
     * 获得两位的月份或日
     *
     * @param s 当前的月或者天
     * @return 两位的时间
     */
    public static String getYueOrDayByFormat(int s) {
        return getYueOrDayByFormat("" + s);
    }

    /**
     * 获得两位的月份或日
     *
     * @param s 当前的月或者天
     * @return 两位的时间
     */
    public static String getYueOrDayByFormat(long s) {
        return getYueOrDayByFormat("" + s);
    }

    /**
     * 获得两位的月份或日
     *
     * @param s 当前的月或者天
     * @return 两位的时间
     */
    public static String getYueOrDayByFormat(String s) {
        if (null == s || s.length() == 0) {
            return "01";
        } else if (s.length() == 1) {
            return "0" + s;
        } else if (s.length() == 2) {
            return s;
        } else {
            throw new RuntimeException("超出范围！");
        }
    }

    /**
     * 获取上个月
     *
     * @param month 本月
     * @return 上个月
     */
    public static String getBeforeMonth(String month) {
        return getBeforeMonth(Integer.parseInt(month));
    }

    /**
     * 获取上个月
     *
     * @param month 本月
     * @return 上月
     */
    public static String getBeforeMonth(int month) {
        if (month > 12 || month < 1) {
            throw new RuntimeException("不是正确的时间");
        } else {
            if (month == 1) {
                month = 13;
            }
            return getYueOrDayByFormat(month - 1);
        }
    }


    /**
     * 获取今天是星期几
     *
     * @return 今天
     */
    public static String getWeekOfDate() {
        return getWeekOfDate(new Date());
    }

    /**
     * 获取数字型的今天是星期几,1,2,3,4,5,6,7
     *
     * @return 今天
     */
    public static Integer getWeekOfDate1() {
        return getWeekOfDate1(new Date());
    }

    /**
     * 获取一个日期是星期几
     *
     * @param dt 时间
     * @return 周几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Integer time = getWeekOfDate1(dt);
        int w = time == 7 ? 0 : time;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取数字型的周几，根据一个给定的日期
     *
     * @param dt 时间
     * @return 周几
     */
    public static Integer getWeekOfDate1(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        Integer time = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return 0 == time ? 7 : time;
    }
}
