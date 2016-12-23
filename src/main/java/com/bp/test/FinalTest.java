package com.bp.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * final的测试类
 * @author current_bp
 * @createTime 20161111
 *
 */
public class FinalTest {
	
	public static void main(String[] args) {
		FinalTest.checkAddressIsChange();
	}
	
	/**
	 * 检查final的对象的值修改，地址是否修改
	 */
	public static void checkAddressIsChange(){
		final AtomicInteger ai = new AtomicInteger(10);
		
		System.out.println("address:"+ai.hashCode()+" value:"+ai.get());
		ai.set(11);
		System.out.println("address:"+ai.hashCode()+" value:"+ai.get());
		/*
		 address:366712642 value:10
		 address:366712642 value:11
		 */
		
		//ai = new AtomicInteger(12);//The final local variable ai cannot be assigned. It must be blank and not using a compound assignment
	}

}
