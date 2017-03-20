package com.bp.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author current_bp
 * @createTime 20161130
 *
 */
public class TimeTest {
	
	public  void getTimeByLong(){
		Long time = 1489994664124L;
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
