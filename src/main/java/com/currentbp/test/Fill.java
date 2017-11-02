package com.currentbp.test;

import java.util.List;


	
	
	



/**
 * 
 * 对list填充给定的符号
 * @author current_bp
 * @createTime 20160513
 *
 */
public class Fill {

	
	private int x;
	private String y;
	
	

	@Override
	public String toString() {
		return "Fill [x=" + x + ", y=" + y + "]";
	}

	public static void main(String[] args) {
		
		
		Fill f = new Fill();
		f.test();
	}
	
	public void test(){
		List l = null;
		
//		l.add("1");
//		l.add("2");
//		l.add("3");
		
		System.out.println("++++"+fill(l)+"======");
	}
	
	
	public String fill(List l){
		return fill(l,",");
	}
	public String fill(List l,String fillName){
		StringBuffer result = new StringBuffer("");
		
		if(null != l){
			for(int i=0;i<l.size();i++){
				result.append(l.get(i)+""+fillName); 
			}
			if(result.length()!=0)
			result.deleteCharAt(result.length()-1);
		}
		
		return result.toString();
	}
}
