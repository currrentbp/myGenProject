package com.bp.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * @author current_bp
 * @createTime 20160807
 *
 */
public class TimerTaskTest {

	private static final Timer timer = new Timer();
	private static int count = 0;
	
	
	public static void main(String[] args) {
		TimerTaskTest tt = new TimerTaskTest();
		tt.useTimeTask();
	}
	
	public void useTimeTask(){
		timer.schedule(new SmsTask(), 1000L, 1000L);//第二个参数是指第一次执行的延迟时间，第三个参数是下次执行时间
	}

	class SmsTask extends TimerTask {
		public void run() {
			System.out.println("Cycle times:"+ count++);
			
		}
	}

}
