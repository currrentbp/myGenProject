package com.bp.util.all;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 关于时间的类。
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class TimeUtil {

	/**
	 * 获得当前精确的时间，精确到毫秒。
	 * 
	 * @return 当前时间
	 */
	public static String currentTimePrecise() {
		String time ;
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
	 * @param year 年>=1900
	 * @param month 月>=1
	 * @param day 日>=1
	 * @param hour 时>=1
 	 * @param min 分>=1
	 * @param sec 秒:>=1
	 * @return 给定时间的毫秒数
	 */
	public static Long getSpecialTime2Long(int year,int month,int day,int hour,int min,int sec){
//		year - 减 1900 的年份。
//		month - 0-11 之间的月份。
//		date - 一月中 1-31 之间的某一天。
//		hrs - 0-23 之间的小时数。
//		min - 0-59 之间的分钟数。
//		sec - 0-59 之间的秒数。
		return new Date(year -1900,month -1, day, hour -1 ,min -1, sec -1).getTime();
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
	 * @return 今天
	 */
	public static String getWeekOfDate(){
		return getWeekOfDate(new Date());
	}
	
	/**
	 * 获取数字型的今天是星期几,1,2,3,4,5,6,7
	 * @return 今天
	 */
	public static Integer getWeekOfDate1(){
		return getWeekOfDate1(new Date());
	}
	
	/**
	 * 获取一个日期是星期几
	 * @param dt 时间
	 * @return 周几
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Integer time = getWeekOfDate1(dt);
		int w = time == 7 ? 0 : time;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	/**
	 * 获取数字型的周几，根据一个给定的日期
	 * @param dt 时间
	 * @return 周几
	 */
	public static Integer getWeekOfDate1(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		Integer time = cal.get(Calendar.DAY_OF_WEEK) -1;
		return 0 == time ? 7 : time;
	}

	public static void main(String[] args) {
		
		
		
		
		
//		//获取今天是星期几
//		System.out.println(TimeUtil.getWeekOfDate());
//		System.out.println(TimeUtil.getWeekOfDate1());
//		Date d = new Date();
//		d.setDate(28);//月份中 1-31 之间的某一天。
//		d.setYear(2016 - 1900);//把此 Date 对象的年份设置为指定的值加 1900。
//		d.setMonth(7);//返回的值在 0 和 11 之间，值 0 表示 1 月
//		System.out.println(d);
//		System.out.println(TimeUtil.getWeekOfDate(d));
//		System.out.println(TimeUtil.getWeekOfDate1(d));
		
		
//		// System.out.println(TimeUtil.getYueOrDayByFormat("122"));
//		System.out.println(TimeUtil.getBeforeMonth(1));


		//根据给定的时间，获取一个其毫秒数
		System.out.println(TimeUtil.getSpecialTime2Long(2016,12,26,14,43,1));
	}
}
