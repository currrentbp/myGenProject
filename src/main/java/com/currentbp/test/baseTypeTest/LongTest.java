package com.currentbp.test.baseTypeTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author current_bp
 * @createTime 20160816
 *
 */
public class LongTest {
	static class S4{

	}

	public static void main(String[] args) {
		class S3{
			private static final int x=1;//com/currentbp/test/baseTypeTest/LongTest.java:21
		}
		S3 s3 = new S3();
		System.out.println("===>"+s3.getClass().getName());
	}
	
	@Test
	public void parseLong(){
		class S3{
			private int x=1;//com/currentbp/test/baseTypeTest/LongTest.java:21
		}
		S3 s3 = new S3();
		System.out.println("===>"+s3.getClass().getName());


		String s1 = "1.1.1";
		String[] split = s1.split("\\.");
//		System.out.println(Long.parseLong(s1));
		String[] subVersions = s1.split("\\.");
		try {
			Long temp = Long.parseLong(subVersions[0]);
			temp = temp * 100 + Long.parseLong(subVersions[1]);
			temp = temp * 1000 + Long.parseLong(subVersions[2]);
			System.out.println(temp);
		} catch (Exception e) {
			throw new RuntimeException("version is error");
		}
		StringUtil.printObject(split);
	}

	@Test
	public void printLong(){
		System.out.println(10000L+"");
	}

	@Test
	public void string2LongWithNull(){
		List<String> l = new ArrayList<>();
		l.add(null);
		l.add("1");
		l.add("2");
		//抛异常了，原因：null不能转换成Long
		List<Long> collect = l.stream().map(Long::parseLong).collect(Collectors.toList());
		StringUtil.printObject(collect);
	}


	@Test
	public void parseToString(){
		System.out.println(Long.toString(10L));
	}

	@Test
	public void remove(){
		List<Long> l1 = new ArrayList<>();
		l1.add(1L);
		long t = 10000000037L;
		l1.remove(t);
		StringUtil.printObject(l1);
	}

	//==========================        测试方法中的实现方法          ===============================================================//
	public void nullToLong(){
		Date date = null;
		System.out.println(date.getTime());
	}

	public void intZeroEqualsLongZero(){
		Long z = 0L;
		int z1 = 0;
		System.out.println("0L == 0 :" +(z1 == z));

	}

	/**
	 * 测试两个长型的数字加后是否出现错误
	 */
	public void longBeyond(){
		System.out.println("result:"+(1110000000000L + 8157436L < 0));

		System.out.println("result2:"+(8157436L > (1110000000000L - 1313238L)));
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
