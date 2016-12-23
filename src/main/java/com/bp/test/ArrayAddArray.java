package com.bp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试两个Array相加成一个Array
 * @author current_bp
 * @createTime 20160622
 *
 */
public class ArrayAddArray {

	public static void main(String[] args) {
		List a1 = new ArrayList();
		List a2 = new ArrayList();
		
		List a3 = new ArrayList();
		List a4 = new ArrayList();
		List a5 = new ArrayList();
		
		a1.add("1");
		a1.add("2");
		a1.add("3");
		
		a2.add("111");
		a2.add("222");
		a2.add("333");
		
		a2.addAll(a1);//测试两个非空的列表是否能相加
		
		System.out.println("a1:"+a1);
		System.out.println("a2:"+a2);
		
		a3.addAll(a1);//测试一个空列表能不能跟一个非空的相加
		
		System.out.println("a3:"+a3);
		
		a4.addAll(a5);
		
		System.out.println("a4:"+a4);
		
	}
}
