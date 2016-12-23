package com.bp.util.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author 校验规则
 * @createTime 20161017
 *
 */
public class CheckUtil {

	/**
	 * 判断一个参数是否是为空或者空串
	 * 
	 * @param paramName
	 * @param source
	 * @throws Exception
	 */
	public static void isEmpty(String paramName, String source) throws Exception {
		if (isEmpty(source)) {
			throw new RuntimeException("param:" + paramName + " is null or empty!");
		}
	}

	/**
	 * 判断一个对象是否为空，可以判断（list,map,set,string,object）
	 * 
	 * @param source
	 * @return
	 */
	public static boolean isEmpty(Object source) {
		if (source instanceof Set) {
			return null == (Set) source || 0 == ((Set) source).size();
		} else if (source instanceof Map) {
			return null == (Map) source || 0 == ((Map) source).size();
		} else if (source instanceof List) {
			return null == (List) source || 0 == ((List) source).size();
		} else if (source instanceof String) {
			return null == (String) source || "".equals(((String) source).trim());
		} else {
			return null == source;
		}
	}

	/**
	 * 判断是否是一个邮箱
	 * 
	 * @param email
	 * @throws Exception
	 */
	public static boolean isEmail(String email) throws Exception {
		isEmpty("email", email);
		final String emailFormal = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

		if (!patternString(emailFormal, email)) {
			throw new RuntimeException("is not a email! email:" + email);
		} else {
			return true;
		}
	}

	/**
	 * 判断是否是一个电话号码
	 * 
	 * @param phone
	 * @throws Exception
	 */
	public static boolean isPhone(String phone) throws Exception {
		isEmpty("phone", phone);
		final String phoneFormal = "^[1][3,4,5,8][0-9]{9}$";

		if (!patternString(phoneFormal, phone)) {
			throw new RuntimeException("is not a phone! phone:" + phone);
		} else {
			return true;
		}
	}

	/**
	 * 根据给定格式匹配一个字符串是否符合该正则表达式
	 * 
	 * @param pattern
	 * @param resource
	 * @return
	 * @throws Exception
	 */
	public static boolean patternString(String pattern, String resource) throws Exception {
		isEmpty("resource", resource);

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(resource);

		return m.matches();
	}

	/**
	 * 测试方法：patternString
	 * 
	 * @throws Exception
	 */
	public static void patternStringTest() throws Exception {
		String fileName1 = "新建文本文档";
		String tail = "txt";
		// 开头1，用括号包围的数字，结尾以文件类型
		String pattern = "^" + fileName1 + " {0,}\\([0-9]{0,}\\)" + "\\." + tail;
		System.out.println("pattern:" + pattern);

		List<String> fileNames = new ArrayList<String>();
		fileNames.add("新建文本文档 (3).txt");

		for (String fileName : fileNames) {
			System.out.println(patternString(pattern, fileName));
		}
	}

	public static void main(String[] args) throws Exception {
		//判断一个对象是否为空
		System.out.println("map:"+CheckUtil.isEmpty(new HashMap()));
		System.out.println("map:"+CheckUtil.isEmpty(null));
		System.out.println("String:"+CheckUtil.isEmpty(""));
		System.out.println("String:"+CheckUtil.isEmpty("ss"));
		System.out.println("List:"+CheckUtil.isEmpty(new ArrayList()));
		List l1 = new ArrayList();
		l1.add("fff");
		System.out.println("List:"+CheckUtil.isEmpty(l1));
		
		
//		// 测试文件名称是否匹配正则
//		CheckUtil.patternStringTest();

		// //测试邮箱
		// System.out.println(CheckUtil.isEmail("1403271248@@qq.com"));
	}

}
