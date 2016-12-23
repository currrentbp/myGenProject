package com.bp.test;

public class StringBufferAndStringBuildTest {
	
	public static void main(String[] args) {
		StringBufferAndStringBuildTest st = new StringBufferAndStringBuildTest();
		
		st.test1();
	}

	public void test1() {
		final StringBuffer sb = new StringBuffer();
		final StringBuilder sb2 = new StringBuilder();
		new Thread() { // A
			public void run() {
				int i = 0;
				while (i++ < 10) {
					sb2.append("ccccC");
					sb.append("aaaaA");
					System.out.println(sb2);
					System.out.println(sb);
				}
			}
		}.start();
		new Thread() { // B
			public void run() {
				int i = 0;
				while (i++ < 10) {
					sb2.append("ddddD");
					sb.append("bbbbB");
					System.out.println(sb2);
					System.out.println(sb);
				}
			}
		}.start();
	}
}
