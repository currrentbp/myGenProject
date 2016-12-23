package com.bp.util.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 数组，列表，等的类
 * 
 * @author current_bp
 * @createTime 20160513
 *
 */
public class ListUtil {

	/**
	 * 将数组填充逗号
	 * 
	 * @param l
	 * @return
	 */
	public static String fill(List l) {
		return fill(l, ",");
	}

	/**
	 * 将数组中填充指定的符号
	 * 
	 * @param l
	 * @param fillName
	 * @return
	 */
	public static String fill(List resourceList, String fillName) {
		StringBuffer result = new StringBuffer("");
		// System.out.println(resourceList);
		List l = pureListWithoutNull(resourceList);
		// System.out.println(l);
		if (null != l) {
			for (int i = 0; i < l.size(); i++) {
				result.append(l.get(i) + "" + fillName);
			}
			if (result.length() != 0) {
				int lastIndex = result.lastIndexOf(fillName);
				result.delete(lastIndex, result.length());
			}
		}

		return result.toString();
	}

	/**
	 * 根据列表计算每个列表的数据和
	 * 
	 * @param list
	 * @return
	 */
	public static int sumNumsFromList(List<Integer> list) {
		int result = 0;

		if (null == list || 0 == list.size()) {
			return result;
		}

		for (int i = 0; i < list.size(); i++) {
			result = result + list.get(i);
		}

		return result;
	}

	/**
	 * 从数组中获取所有数据的和
	 * 
	 * @param array
	 * @return
	 */
	public static int sumNumsFromArray(Integer[] array) {
		int result = 0;

		if (null == array || 0 == array.length) {
			return result;
		}

		for (int i = 0; i < array.length; i++) {
			result = result + array[i];
		}

		return result;
	}

	/**
	 * 通过一个列表获取一个没有null的列表
	 * 
	 * @param l
	 * @return
	 */
	public static List pureListWithoutNull(List l) {
		List result = new ArrayList();

		if (null == l || 0 == l.size()) {
			return result;
		}

		for (Object o : l) {
			if (null != o) {
				result.add(o);
			}
		}

		return result;
	}

	/**
	 * 翻转list
	 * 
	 * @param resource
	 * @return
	 */
	public static List reverseList(List resource) {
		if (null == resource) {
			return null;
		}

		List result = new ArrayList();

		if (0 == resource.size()) {
			return result;
		}

		for (int i = resource.size() - 1; i >= 0; i--) {
			result.add(resource.get(i));
		}

		return result;
	}

	/**
	 * 将string类型的列表转换成integer的列表
	 * @param source
	 * @return
	 */
	public List<Integer> stringList2IntegerList(List<String> source) {
		List<Integer> result = new ArrayList<Integer>();

		if (CheckUtil.isEmpty(source)) {
			return result;
		}
		
		for (String s : source) {
			try {
				result.add(Integer.parseInt(s));
			} catch (Exception e) {
			}
		}
		
		return result;
	}
	
	/**
	 * 将string类型的list转为long类型的list
	 * @param source
	 * @return
	 */
	public List<Long> stringList2LongList(List<String> source) {
		List<Long> result = new ArrayList<Long>();

		if (CheckUtil.isEmpty(source)) {
			return result;
		}
		
		for (String s : source) {
			try {
				result.add(Long.parseLong(s));
			} catch (Exception e) {
			}
		}
		
		return result;
	}

	public static void main(String[] args) {

		// 翻转list
		List l = new ArrayList();
		l.add("1");
		l.add("2");
		l.add(null);
		l.add("3");
		System.out.println(l);
		System.out.println(ListUtil.reverseList(l));

		// List l = new ArrayList();
		// l.add("1");
		// l.add("2");
		// l.add(null);
		// l.add("3");
		// System.out.println(ListUtil.fill(l," "));
	}
}
