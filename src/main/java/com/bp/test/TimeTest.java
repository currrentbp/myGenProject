package com.bp.test;

import java.util.Date;

/**
 * 
 * @author current_bp
 * @createTime 20161130
 *
 */
public class TimeTest {
	
	public static void main(String[] args) {
		TimeTest tt = new TimeTest();
		
		tt.printNowTimeLong();
		tt.printSomeTimeLong();
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
