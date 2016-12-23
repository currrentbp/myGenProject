package com.bp.test;

/**
 * 
 * @author current_bp
 * @createTime 20160816
 *
 */
public class LongTest {

	public static void main(String[] args) {

		LongTest lt = new LongTest();
		lt.addressIsEqual();
	}

	/**
	 * 将long转换到integer类型
	 */
	public void longToInteger() {
		Long l = 11111111L;

		Integer i = Integer.parseInt(String.valueOf(l));

		System.out.println(i);
	}

	/**
	 * 判断两个值相同的，结果相同否
	 */
	public void addressIsEqual() {
		// 判断两个值相同的，结果相同否
		System.out.println(new Long(1) == new Long(1));
		System.out.println(new Long(1000) == new Long(1000));

		System.out.println(new Integer(1) == new Integer(1));
		System.out.println(new Integer(1000) == new Integer(1000));
		System.out.println(new Integer(1).equals(new Integer(1)));
	}
}
