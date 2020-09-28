package com.currentbp.test.javaBaseTest;

/**
 * null测试类
 * @author current_bp
 * @createTime 20160805
 *
 */
public class NullTest {


	//==========================        测试方法中的实现方法          ===============================================================//
	
	/**
	 * 测试null加一个非空的值后是什么
	 */
	public void nullAddNotNull(){
		String nul = null;
		nul += "\n";
		System.out.println(nul);
		System.out.println(nul.equals("null"));
		System.out.println(nul.equals("null\n"));
	}
	/**
	 * 测试null 等于 null
	 */
	public void nullEqualNull(){
		boolean flag = null == null;
		String s1 = null;
		String s2 = null;
		System.out.println("flag:"+flag);
		boolean flag2 = s1.equals(s2);//有问题，
		
		System.out.println("flag:"+flag+" flag2:"+flag2);
	}
	
	/**
	 * null + null
	 */
	public void nullPlusNull(){
		String s1 = null;
		String s2 = "0";
		System.out.println(s1+","+s2);
	}
	
	/**
	 * 测试是否为null
	 */
	public void isNull(){
		String s1 = null;
		if(s1 == null){
			System.out.println("====");
		}else{
			System.out.println("+++++++");
		}
	}
}
