package com.bp.test;

import java.util.Iterator;
import java.util.Map;


/**
 * 
  * @author current_bp
 * @time 20160405
 *
 */
public class MyGetEnv {
	
	public static void main(String[] args) {
		Map map = System.getenv(); 
		
		System.out.println("map:"+map);
		
		System.out.println("USERPROFILE:"+map.get("USERPROFILE"));
		
		Iterator iter = map.entrySet().iterator();
		
		while (iter.hasNext())
		{
			System.out.println("key:");
		}
		
		
	}

}
