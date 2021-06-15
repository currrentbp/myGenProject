package com.currentbp.test.baseTypeTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author current_bp
 * @createTime 20160816
 *
 */
public class LongTest {

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
