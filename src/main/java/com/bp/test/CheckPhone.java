package com.bp.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author current_bp
 * @createTime 20161014
 *
 */
public class CheckPhone {

	public final static String f1 = "^[1][3,4,5,8][0-9]{9}$";
	public final static String f2 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";//maybe is error

	public static void main(String[] args) {
		Pattern p = Pattern.compile(CheckPhone.f2);
		Matcher m = p.matcher("18210009241");

		System.out.println( m.matches());
	}

}
