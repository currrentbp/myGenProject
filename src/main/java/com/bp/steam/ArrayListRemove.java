package com.bp.steam;

import java.util.ArrayList;

/**
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class ArrayListRemove {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(1);
		list.add("111");
		list.add(3);
		
		for(int i= 0;i<list.size();)
		{
			System.out.println(list.get(0));
			list.remove(0);
		}
		System.out.println("list.size():"+list.size());
	}
}
