package com.currentbp.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author current_bp
 * @createTime 20161130
 *
 */
public class TimeTest {

	@Test
	public void formatTime(){
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日");
		String result = "缺货，预计"+formater.format(new Date(date.getTime()+ 154 * 24 * 60 * 60 * 1000L))+"到货";
		String target = new SimpleDateFormat("yyyy年").format(date);
		String replace = result.replace(target, "");
		System.out.println(replace);
	}
	
	public  void getTimeByLong(){
		Long time = 1487845207000L;
		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time1 = simpleDateFormat.format(date);
		System.out.println(time1);
	}
	
	/**
	 * 打印当前的时间
	 */
	public void printNowTimeLong(){
		System.out.println("time:"+System.currentTimeMillis());
	}
	
	public void printSomeTimeLong(){
		Date d = new Date();
		
		d.setYear(2016-1900);
		d.setMonth(10);
		d.setDate(29);
		d.setHours(10);
		d.setMinutes(10);
		d.setSeconds(10);
		
		System.out.println(d.getTime());
	}
	
	

}
