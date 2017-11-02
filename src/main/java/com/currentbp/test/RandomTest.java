package com.currentbp.test;

import java.util.Random;

/**
 * 
 * @author current_bp
 * @createTime 20161125
 *
 */
public class RandomTest {
	
	public static void main(String[] args) {
		Random ran = new Random(10);
		for(int i = 0; i < 10; i++){
			Random ran2 = new Random(10);
			System.out.println(ran.nextInt() + "-1-");
			System.out.println("               " + ran2.nextInt() + "-2-");
		}
	}

}
