package com.bp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author current_bp
 * @createTime 20160802
 *
 */
public class ArrayListParamReference {
	
	
	public static void main(String[] args) {
		ArrayListParamReference a = new ArrayListParamReference();
		a.init();
	}
	
	public void init(){
		
		List l2 = null;
//		l2 = new ArrayList();
		useArrayList(l2);
		System.out.println(l2);
	}
	
	public void useArrayList(List l1){
		if(null != l1){
			l1.add(3);
			l1.add(5);
		}else{
			l1 = new ArrayList();
			l1.add(4);
			l1.add(6);
		}
	}
}
