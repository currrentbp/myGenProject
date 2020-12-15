package com.currentbp.util.all;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 关于random 集合
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class RandomUtil {

	private static Random random = new Random(new Date().getTime());

	public static Random getRandom() {
		return random;
	}

	/**
	 * 随机一个从a到z或者从A到Z的值
	 * 
	 * @param flag:true：小写，false：大写
	 * @return
	 */
	public static char randomaTozOrAToZ(boolean flag) {
		char c = (char) (Math.random() * 26 + (flag ? 'a' : 'A'));
		System.out.println("c:" + c);
		return c;
	}

	/**
	 * 获取6位的 随机字符
	 * 
	 * @return
	 */
	public static String getRandomString6s() {
		return getRandomString(6);
	}

	/**
	 * 根据长度获取随机字符
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		return getRandomString("", length);
	}

	/**
	 * 根据给定的字符获取随机字符，给定字符可以为空
	 * 
	 * @param o
	 * @param length
	 * @return
	 */
	public static String getRandomString(String o, int length) {

		if (null == o || "".equals(o)) {
			o = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		}
		int range = o.length();
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(range);
			buf.append(o.charAt(num));
		}
		return buf.toString();
	}

	/**
	 * 获取一个唯一的数字类型的字符串
	 * 
	 * @return
	 */
	public static String getUniqueNumString() {
		String result = "";
		// 时间部分
		String s1 = StringUtil.getStringWithOutSome(TimeUtil.currentTimePrecise(), "-");
		String s2 = StringUtil.getStringWithOutSome(s1, " ");
		String s3 = StringUtil.getStringWithOutSome(s2, ":");
		// 随机数部分
		System.out.println(s3);
		int x = random.nextInt(100000);
		System.out.println("x:" + x);
		String ran = StringUtil.fillBySome(5, x);

		return s3 + ran;
	}

	/**
	 * 获取UUID
	 * 
	 * @return UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获取UUID，没有‘-’
	 * 
	 * @return UUID
	 */
	public static String getUUID2(){
		return getUUID().replace("-", "");
	}

	/**
	 * 获取随机数，最大随机数包含maxNum
	 * 
	 * @param maxNum 最大随机数
	 * @return 随机数
	 */
	public static int getRandomNumIncludeMaxnum(int maxNum) {
		return getRandomNum(maxNum + 1);
	}

	/**
	 * 获取随机数，但是随机数小于maxNum
	 * 
	 * @param maxNum 最大随机数
	 * @return 随机数
	 */
	public static int getRandomNum(int maxNum) {
		return (int) (Math.random() * maxNum);
	}

	public static long getRandomNum(long maxNum) {
		return (int) (Math.random() * maxNum);
	}

	/**
	 * 获取比较大的数的随机数
	 * 
	 * @param largeNum 最大随机数
	 * @return 随机数
	 */
	public static int getLargeRandomNum(int largeNum) {
		Random random = new Random();
		return random.nextInt(largeNum) + 1;
	}

	public static void main(String[] args) {

		// for (int i = 0; i < 10; i++)
		// System.out.println(getRandomNum(0));

		// for(int i=0;i<1000;i++)
		// System.out.println(RandomUtil.getUniqueNumString());

		// RandomUtil r = new RandomUtil();
		// r.randomaTozOrAToZ(true);
		
		System.out.println(RandomUtil.getUUID());
		System.out.println(RandomUtil.getUUID2());

	}
}
