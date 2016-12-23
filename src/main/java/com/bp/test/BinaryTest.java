package com.bp.test;

public class BinaryTest {

	
	public static void testBinary1(){
		System.out.println(1 << 4);
	}
	
	public static void testBinary2(){
		System.out.println(4 & 7 * 2);//4
		System.out.println(4 & (7 * 2));//4
		System.out.println((4 & 7) * 2);//8
		System.out.println(4&7);//4
		System.out.println(4&14);//4
		
		
		//说明位运算比四则运算要低级
	}
	
	public static void main(String[] args) {
		BinaryTest.testBinary1();
		BinaryTest.testBinary2();
	}
}
