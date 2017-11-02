package com.currentbp.test;
/**
 * 
 * @author current_bp
 * @createTime 20160824
 *
 */
public class HolderTest {
	

	

	public static void main(String[] args) {
		
		
	}
	class UseHolder implements Runnable{
		public Holder h;
		public UseHolder(Holder h) {
			this.h = h;
		}
		
		@Override
		public void run() {
			
		}
		
	}
	class Holder{
		public int n;

		public Holder(int n) {
			this.n = n;
		}

		public void assertSanity() {
			if (n != n) {
				throw new RuntimeException("=====error=======");
			}else{
				System.out.println("is ok");
			}
		}
	}

	
}
