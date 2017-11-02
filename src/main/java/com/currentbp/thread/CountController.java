package com.currentbp.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 关于数量控制器
 * 
 * @author current_bp
 * @createTime 20161125
 *
 */
public class CountController {

	public static void main(String[] args) throws InterruptedException {

		CountController cc = new CountController();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("i:" + i);
				}
			}
		};

		Long time = cc.timeTasks(1000, task);
		System.out.println("time = " + time);
	}

	/**
	 * 限定nThreads个线程，执行task一样的内容，计算一共花的时间
	 * 
	 * @param nThreads
	 *            ：任务执行次数
	 * @param task
	 *            : 任务内容
	 * @return
	 * @throws InterruptedException
	 */
	public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();

						try {
							task.run();

						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException e) {
					}
				}
			};
			t.start();

		}

		//纳秒
		//1纳秒=0.000001 毫秒 
		//1纳秒=0.00000 0001秒
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		Long end = System.nanoTime();

		return end - start;

	}

}
