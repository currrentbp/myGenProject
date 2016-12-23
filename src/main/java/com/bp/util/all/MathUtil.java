package com.bp.util.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 数学函数
 * 
 * @author current_bp
 * @createTime 20160519
 */
public class MathUtil {

	/**
	 * 将long类型的数据除以2
	 * 
	 * @param divideNum
	 * @return
	 */
	public static long divideTwo(long divideNum) {
		return divideNum >> 1;
	}

	/**
	 * 将int类型的数据除以2
	 * 
	 * @param divideNum
	 * @return
	 */
	public static int divideTwo(int divideNum) {
		return divideNum >> 1;
	}

	/**
	 * 将long类型的数据乘以2
	 * 
	 * @param multTwo
	 * @return
	 */
	public static long multTwo(long multTwo) {
		return multTwo << 1;
	}

	/**
	 * 将int类型的数据乘以2
	 * 
	 * @param multNum
	 * @return
	 */
	public static int multTwo(int multNum) {
		return multNum << 1;
	}

	/**
	 * 计算两点之间距离（默认到原点距离）
	 * 
	 * @param x1
	 * @param y1
	 * @return
	 */
	public static float distanceFromTwoPlace(float x1, float y1) {
		return distanceFromTwoPlace(0, 0, x1, y1);
	}

	/**
	 * 计算两点之间距离
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static float distanceFromTwoPlace(float x1, float y1, float x2, float y2) {
		return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	// submultiple约数，因数;
	/**
	 * 求出一个数的所有的约数包括（1，self）
	 * 
	 * @param num
	 * @return
	 */
	public List<Integer> allSubmultiple(int num) {
		List<Integer> result = new ArrayList<Integer>();
		if (0 >= num) {
			throw new RuntimeException("求所有的约数时，不允许数字为负数或零！");
		}

		// 添加最小约数
		result.add(1);

		if (2 <= MathUtil.divideTwo(num)) {
			for (int i = 2; i <= MathUtil.divideTwo(num); i++) {
				if (0 == num % i) {
					result.add(i);
				}
			}
		}

		// 添加最大约数
		result.add(num);

		return result;
	}

	/**
	 * 公约数(Common divisor)
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int maxCommonDivisor(int num1, int num2) {
		int result = 1;

		if (num1 <= 0 || num2 <= 0) {
			throw new RuntimeException("求最大公约数，不允许数字为负数或零！");
		}

		int maxNum = num1 < num2 ? num2 : num1;

		for (int i = 1; i <= maxNum; i++) {
			if (0 == num1 % i && 0 == num2 % i) {
				result = i;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		// //求出一个数的所有约数
		// MathUtil mu = new MathUtil();
		// System.out.println(mu.allSubmultiple(124));

		// //求最大公约数
		// System.out.println(MathUtil.maxCommonDivisor(8, 4));

		// //与原点之间的距离，或者两点之间的距离
		// System.out.println(MathUtil.distanceFromTwoPlace(1, 1));

		// System.out.println(MathUtil.divideTwo(5));
		// System.out.println(MathUtil.multTwo(5));
		// System.out.println(MathUtil.divideTwo(5L));
		// System.out.println(MathUtil.multTwo(5L));

	}
}
