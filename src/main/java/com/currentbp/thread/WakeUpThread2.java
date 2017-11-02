package com.currentbp.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author current_bp
 * @createTime 20161025
 *
 */
public class WakeUpThread2 {
	/*
	 * 准备测试线程等待和唤醒指定线程
	 */
	
	private List<PrivateThread> ptLists = new ArrayList<PrivateThread>();
	
	/**
	 * 初始化3个线程
	 * @throws InterruptedException 
	 */
	public void init() throws InterruptedException{
		for(int i=0;i<2;i++){
			PrivateThread pt = new PrivateThread("thread"+i);
			ptLists.add(pt);
		}
		for(int i=0;i<2;i++){
			ptLists.get(i).start();
		}
		
		
	}
	

	/**
	 * 先唤醒指定的第二个线程，然后唤醒其他的线程
	 */
	public void notifyThread(){
		System.out.println("=============notify...");
		ptLists.get(1).setFlag(false);
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		WakeUpThread2 wt = new WakeUpThread2();
		wt.init();
		Thread.sleep(3 * 1000L);
		wt.notifyThread();
		
	}
	
	
	
	
	
	
	
	class PrivateThread extends Thread{
		private String threadName ;
		private volatile boolean flag = true;
		public PrivateThread() {
		}
		public PrivateThread(String threadName ) {
			this.threadName = threadName;
		}


		@Override
		public void run() {
			System.out.println("===>thread:"+this.threadName+" starting ...");
			while(flag){
				System.out.println("===>thread:"+this.threadName+" time:"+new Date().getTime());
				try {
					Thread.sleep(1*1000L);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("===>thread:"+this.threadName+" over!");
		}
		
		
		
		
		public boolean isFlag() {
			return flag;
		}
		public void setFlag(boolean flag) {
			this.flag = flag;
		}
		
		
	}
}
