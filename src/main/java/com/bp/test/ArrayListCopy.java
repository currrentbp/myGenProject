package com.bp.test;

import java.util.ArrayList;

/**
 * 测试ArrayList:clone()_返回此 ArrayList 实例的浅表副本。
 * 这个不是将地址复制给别人。
 * @author current_bp
 * @time 20160405
 *
 */
public class ArrayListCopy {

	public void testClone()
	{
		ArrayList a = new ArrayList();
		a.add(1);
		a.add(2);
		
		ArrayList b = (ArrayList)a.clone();
		
		b.add(3);
		System.out.println(b+"  ++++++" + a);
		
	}
	public static void main(String[] args) {
		ArrayListCopy test = new ArrayListCopy();
		test.testClone();
	}
}
