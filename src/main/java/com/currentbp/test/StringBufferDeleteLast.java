package com.currentbp.test;


/**
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class StringBufferDeleteLast {
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("12");
		System.out.println("++++++"+sb.delete(sb.length()-1, sb.length())+"====");
		
		String s = "1,2,3,";
		int index = s.lastIndexOf(",");
		
		if(s.length()-1 == index){
			System.out.println("equal");
		}else{
			System.out.println("not equal,s.length:"+s.length()+" index:"+index);
		}
	}
}
