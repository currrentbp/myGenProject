package com.currentbp.util.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author current_bp
 * @time 20160405
 */
public class SortUtil {

	/**
	 * 冒泡(bubble sorting),默认：升序排序
	 * 
	 * @param resource
	 * @return
	 */
	public List<Integer> bubblSort(List<Integer> resource) {
		return bubblSort(resource, true);
	}

	/**
	 * 冒泡(bubble sorting)
	 * 
	 * @param resource
	 * @param isAsc:
	 *            是否升序
	 * @return
	 */
	public List<Integer> bubblSort(List<Integer> resource, boolean isAsc) {
		List<Integer> result = new ArrayList<Integer>();

		if (null == resource || 0 == resource.size()) {
			return resource;
		} else {
			result = resource;
		}

		for (int i = 0; i < result.size(); i++) {

			for (int j = i; j < result.size(); j++) {
				if (swapCondition(isAsc, result, i, j)) {
					swap(result, i, j);
				}
			}
		}

		return result;
	}

	/**
	 * 排序时，升序：第一个小于第二个数，就不需要换位置，否则换位置， 降序：第一个大于第二个时，不需要换位置，否则换位置
	 * 
	 * @param isAsc：是否是升序
	 * @param resource：原数据源
	 * @param location1：位置一
	 * @param location2：位置二
	 * @return
	 */
	public boolean swapCondition(boolean isAsc, List<Integer> resource, int location1, int location2) {
		if (isAsc) {// 升序
			if (resource.get(location1) < resource.get(location2)) {
				return false;
			} else {
				return true;
			}
		} else {// 降序
			if (resource.get(location1) > resource.get(location2)) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 互换两个位置的数据
	 * 
	 * @param resource：数据源
	 * @param location1：位置一
	 * @param location2：位置二
	 */
	public void swap(List<Integer> resource, int location1, int location2) {
		int temp = resource.get(location1);
		resource.set(location1, resource.get(location2));
		resource.set(location2, temp);
	}

	/**
	 * 排序方法：默认升序
	 * 
	 * @param resource
	 * @return
	 */
	public List<Integer> bubblSort2(List<Integer> resource) {
		return bubblSort2(resource, true);
	}

	/**
	 * 排序方法
	 * 
	 * @param resource
	 * @param isAsc:是否升序
	 * @return
	 */
	public List<Integer> bubblSort2(List<Integer> resource, boolean isAsc) {
		if (isAsc) {
			Collections.sort(resource, new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					return -1 * b.compareTo(a);
				}
			});
		} else {
			Collections.sort(resource, new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					return b.compareTo(a);
				}
			});
		}
		return resource;
	}

	
	/**
	 * 排序方法:JDK1.8：默认升序
	 * @param resource
	 * @return
	 */
	public List<Integer> bubblSort3(List<Integer> resource){
		return bubblSort3(resource,true);
	}
	/**
	 * 排序方法:JDK1.8
	 * @param resource
	 * @return
	 */
	public List<Integer> bubblSort3(List<Integer> resource, boolean isAsc) {
		/*if (isAsc) {
			Collections.sort(resource, (Integer a, Integer b) -> {
				return -1 * b.compareTo(a);
			});
		} else {
			Collections.sort(resource, (Integer a, Integer b) -> {
				return b.compareTo(a);
			});
		}*/

		return resource;
	}

	/**
	 * 例子
	 */
	public void exemple() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		System.out.println("names:" + names);
	}

	public static void main(String[] args) {
		
		
		
		

//		// 排序：升序
//		List<Integer> l1 = new ArrayList<Integer>();
//		l1.add(5);
//		l1.add(3);
//		l1.add(1);
//		l1.add(4);
//		l1.add(2);
//		l1.add(5);
//		SortUtil su = new SortUtil();
//		// 排序：升序
//		System.out.println(su.bubblSort3(l1, true));

		// // 排序：升序
		// List<Integer> l1 = new ArrayList<Integer>();
		// l1.add(5);
		// l1.add(3);
		// l1.add(1);
		// l1.add(4);
		// l1.add(2);
		// l1.add(5);
		// SortUtil su = new SortUtil();
		// // 排序：升序
		// System.out.println(su.bubblSort2(l1,false));

		// //排序：升序
		// List<Integer> l1 = new ArrayList<Integer>();
		// l1.add(5);
		// l1.add(3);
		// l1.add(1);
		// l1.add(4);
		// l1.add(2);
		// l1.add(5);
		// SortUtil su = new SortUtil();
		// //排序：升序
		// System.out.println(su.bubblSort(l1));
		// //排序：降序
		// System.out.println(su.bubblSort(l1, false));
	}
}
