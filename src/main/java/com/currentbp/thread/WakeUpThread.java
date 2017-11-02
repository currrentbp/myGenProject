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
public class WakeUpThread {
	/*
	 * 准备测试线程等待和唤醒指定线程
	 */
	
	private List<PrivateThread> ptLists = new ArrayList<PrivateThread>();
	
	/**
	 * 初始化10个线程
	 * @throws InterruptedException 
	 */
	public void init() throws InterruptedException{
		for(int i=0;i<3;i++){
			PrivateThread pt = new PrivateThread("thread"+i);
			pt.run();
			pt.wait();
			ptLists.add(pt);
		}
	}

	/**
	 * 先唤醒指定的第二个线程，然后唤醒其他的线程
	 */
	public void notifyThread(){
		ptLists.get(2).setFlag(false);
		ptLists.get(2).notify();
		
		this.notify();
		for(int i=0;i<3;i++){
			ptLists.get(i).flag= false;
		}
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		WakeUpThread wt = new WakeUpThread();
		wt.init();
		wt.notifyThread();
//		while(true){
//			
//		}
	}
	
	
	
	
	
	
	
	class PrivateThread implements Runnable{
		private String threadName ;
		private volatile boolean flag = true;
		public PrivateThread() {
		}
		public PrivateThread(String threadName ) {
			this.threadName = threadName;
		}


		@Override
		public void run() {
			System.out.println("===>thread:"+this.threadName+" waiting ...");
			while(flag){
				System.out.println(""+new Date().getTime());
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
