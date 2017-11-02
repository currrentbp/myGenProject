package com.currentbp.test;

/**
 * 测试内部类能使用外部类的参数
 * @author current_bp
 * @createTime 20160622
 *
 */
public class InnerClassCanUseOuterParam {

	private String s1 = "ssssss";
	
	public void userInnerClassNewInstance(){
		InnerClass ic = new InnerClass();
		
		ic.userOuterParam();
	}
	
	
	
	public static void main(String[] args) {
		InnerClassCanUseOuterParam i = new InnerClassCanUseOuterParam();
		
		i.userInnerClassNewInstance();
	}
	
	
	private class InnerClass{
		public void userOuterParam(){
			System.out.println(s1);
		}
	}
}
