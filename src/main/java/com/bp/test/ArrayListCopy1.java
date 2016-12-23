package com.bp.test;

import java.util.ArrayList;
/**
 * 显示了这种赋值就是将地址直接给别人了，别人可以更改其内容。
 * @author current_bp
 * @time 20160405
 *
 */
public class ArrayListCopy1 {

	public void testMyList(){
		ArrayList al1 = new ArrayList();
		al1.add(1);
		ArrayList al2 = al1;
		al2.add(2);
		System.out.println(al2+" =====" +al1);
		
	}
	
	public static void main(String[] args) {
		ArrayListCopy1 test = new ArrayListCopy1();
		test.testMyList();
	}
}
