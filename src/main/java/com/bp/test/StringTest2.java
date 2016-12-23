package com.bp.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest2 {

	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		String newFileName = "bao.pan.txt";
		int lastIndex = newFileName.lastIndexOf(".");
		
		System.out.println(lastIndex);
		Integer i = new Integer(0);
		System.out.println(i.parseInt("ssss"));
		
		System.out.println( newFileName.substring(0,lastIndex));
		System.out.println( newFileName.substring(lastIndex,newFileName.length()));
		
	}
}
