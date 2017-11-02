package com.currentbp.test;

/**
 * 
 * @author current_bp
 * @createTime 20160805
 *
 */
public class UnsafeSequence {

	private NotSafeSequence notSafeSequence = null;// 此处原本为null

	public NotSafeSequence getNewInstance() {
		if (null == notSafeSequence) {//提升效率
			synchronized (this) {
				if (null == notSafeSequence) {
					notSafeSequence = new NotSafeSequence();
				}
			}
		}

		return notSafeSequence;
	}

	public void useThread() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					// 测试结果，由于该对象不是唯一的，所以产生了获取getNext的值不能达到目标
					System.out.println("===>getNewInstance():" + getNewInstance().hashCode());
					System.out.println("thread:" + this.hashCode() + "===>value:" + getNewInstance().getNext());
				}
			}

		});
		t1.start();
	}

	public static void main(String[] args) {
		UnsafeSequence un = new UnsafeSequence();
		un.useThread();
		un.useThread();
	}

	class NotSafeSequence {
		private int value;

		public int getNext() {
			return value++;
		}
	}

}
