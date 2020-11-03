package com.currentbp.test.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 每次增加一到两个数字到数组中
 * @author current_bp
 * @createTime 20160623
 *
 */
public class EachTimeCreateNewToArray {

	public static void main(String[] args) {
		int count = 0;
		int max = 10;
		List l = new ArrayList();
		l.add("1");
		l.add(2);
		
		for(int i=0;i<l.size(); i++){
			List l1 = new ArrayList();
			l1.add(count);
			
			l.addAll(l1);
			
			count++;
			if(max < count){
				break;
			}
		}
		System.out.println("size:"+l.size());
		System.out.println(l);
	}
}
