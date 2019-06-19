package com.currentbp.test;
/**
 * 这个测试两个递归同时在一个条件下执行，结果显示这个是呈发散式展开的。
  * @author current_bp
 * @time 20160405
 *
 */
public class Recursion {
	
	public void testRecursion(int i){
		
		System.out.println("this i is :"+i);
		if(i<10)
		{
			testRecursion(i+1);
			
			testRecursion(i+1);
		}
		System.out.println("my annotationForTest this is i:"+i);
	}
	
	public static void main(String[] args) {
		Recursion re = new Recursion();
		re.testRecursion(0);
	}
}
