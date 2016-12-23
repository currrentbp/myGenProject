package com.bp.test;
/**
 * 所有类型的数字类型对比,使用string，包括int ,double,float
 * @author current_bp
 * @createTime 20160630
 *
 */
public class AllTypeNumCompare {
	
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "2";
		String s3 = "0.1";
		String s4 = "1.1";
		
		String s5 = "a";
		String s6 = "b";
		
		System.out.println("s1>s2:"+s1.compareTo(s2));
		System.out.println("s2>s1:"+s2.compareTo(s1));
		System.out.println("===========");
		System.out.println("s3>s4:"+s3.compareTo(s4));
		System.out.println("s4>s3:"+s4.compareTo(s3));
		System.out.println("===========");
		System.out.println("s1>s4:"+s1.compareTo(s4));
		System.out.println("s4>s1:"+s4.compareTo(s1));
		System.out.println("===========");
		System.out.println("s5>s6:"+s5.compareTo(s6));
		
	}

}
