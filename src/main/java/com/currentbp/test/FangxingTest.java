package com.currentbp.test;



/**
 * 
 * @author current_bp
 * @createTime 20161201
 *
 */
public class FangxingTest {
	
	
	public static void main(String[] args) {
		FangxingTest fx = new FangxingTest();
		fx.fx1();
	}
	
	public void fx1(){
		//?表示前面的那个字符出现一次或者0次
		System.out.println("-911".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
	}

}
