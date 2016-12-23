package com.bp.test;

/**
 * 
 * @author current_bp
 * @createTime 20161024
 *
 */
public class SpecialFunction {
	/*
	 * 测试一个比较特殊的写法
	 */
	
	public static void main(String[] args) {
		SpecialFunction sf = new SpecialFunction();
		sf.myFunction(1, 2);
	}

	public boolean myFunction(int x,int y){
		
		return x>y ? true : (Boolean)getResultAndLogger(false, new String[]{"x","y"},new Integer[]{x,y});
	}
	
	/**
	 * 
	 * @param resource
	 * @param allParams ：【names】，【values】
	 * @return
	 */
	public Object getResultAndLogger(Object resource,Object ... allParams){
		
		for(int i=0;i<((Object[])allParams[0]).length;i++){
			System.out.print(""+((Object[])allParams[0])[i]+":"+((Object[])allParams[1])[i]+" ");
		}
		return resource;
	}
}
