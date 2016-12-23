package com.bp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试ArrayList 的空判断
 * @author current_bp
 * @createTime 20160712
 *
 */
public class ArrayListNullTest {

	public static void main(String[] args) {
		List l1 = null;
		
//		l1 = new ArrayList();
		
		if(null != l1 && 0 != l1.size()){
			System.out.println("not null");
		}else{
			System.out.println("is null");
		}
		
		if(null == l1 || 0 == l1.size()){
			System.out.println("not null");
		}else{
			System.out.println("is null");
		}
	}
}
