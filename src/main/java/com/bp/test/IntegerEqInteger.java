package com.bp.test;

/**
 * 
 * @author current_bp
 * @createTime 20160804
 *
 */
public class IntegerEqInteger {

	
	public static void main(String[] args) {
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		
		System.out.println(i1 == i2);
		System.out.println(i1.intValue() == i2);
		System.out.println(i1 == i2.intValue());
		System.out.println(i1.intValue() == i2.intValue());
		System.out.println(i1.equals(i2));
		System.out.println(i1.equals(i2.intValue()));
	}
}
