package com.bp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bp.util.all.TimeUtil;
import org.junit.Test;


public class StringTest {
	
	public List<String> l1 = new ArrayList<String>();
	public List<String> l2 = new ArrayList<String>();
	/**
	 * 测试速度,没有测试成功
	 * this.path.indexOf(0) < 0
	 * path == null 
	 */
	public void sudu(){
		boolean flag = true;
		Long t1 ;
		Long t2 ;
		Long t3;
		Long t4;
		
		addL1AndL2();
		
		
		t1 = TimeUtil.currentTimeToLong();
		for(int i=0;i<1000000;i++){
			flag = l1.get(i).indexOf(0)<0;
		}
		t2 = TimeUtil.currentTimeToLong();
		System.out.println("time1:"+(t2-t1));
		
		t3 = TimeUtil.currentTimeToLong();
		for(int i=0;i<1000000;i++){
			flag = "".equals(l2.get(i));
		}
		t4 = TimeUtil.currentTimeToLong();
		System.out.println("time2:"+(t4-t3));
	}
	public void addL1AndL2(){
		for(int i=0;i<1000000;i++){
			if( (i & 2) == 0){
				l1.add(i,"");
			}else{
				l1.add(i,"1");
			}
		}
		
		for(int i=1;i<1000001;i++){
			if( (i & 2) == 0){
				l2.add(i-1,"");
			}else{
				l2.add(i-1,"1");
			}
		}
	}

	public static final void main(String[] args) {
		StringTest stringTest = new StringTest();
		
		
//		StringTest st = new StringTest();
//		st.isWin();
		
//		StringTest st = new StringTest();
//		st.sudu();
//		HashMap<String,String> map = new HashMap<String, String>();
//		//测试0是啥。。
//		String path="";
//		path = new String("abcdefABCDEF");
//		System.out.println(path.indexOf(41) );

//		//测试除数为0的这种情况
//		stringTest.isZero(10,0);

//		//测试数字和字符串的相等性问题
//		stringTest.isEqualWithEmpty();

//		//获取分割的字符串
//		stringTest.getSplitString();

		//判断1是否等于null
//		stringTest.equalsNull();

		//判读一个字符串中是否包含一个字符
//		stringTest.stringContain();

		//获取0到0的字符串
		stringTest.getZero2Zero();
	}


	/**
	 * 获取0到0的字符串:结果为空串
	 */
	public void getZero2Zero(){
		String s1 = "1.2.3";
		System.out.println("========="+s1.substring(0,1)+"=========");
		System.out.println("".equals(s1.substring(0,0)));
		System.out.println(s1.split("\\.")[2]);
		System.out.println((int)s1.charAt(0));
	}

	/**
	 * 判读一个字符串中是否包含一个字符
	 */
	public void stringContain(){
		System.out.println("1.1".contains("."));
		System.out.println("11".contains("."));
	}

	/**
	 * 判断1是否等于null
	 */
	@Test
	public void equalsNull(){
		System.out.println("1".equals(null));
	}

	/**
	 * 获取分割的字符串
	 */
	public void getSplitString(){
		String s1 = "baopan_1";
		System.out.println("before:"+s1.split("_")[0]+" after:"+s1.split("_")[1]);
	}



	/**
	 * 测试常量的值是否相等
	 */
	public void isEqualWithEmpty(){
		Integer x = 1;
		String s1 = "1";
		System.out.println("isEqual:"+s1.equals(""+x));
	}

	/**
	 * 测试除数为0的这种情况
	 * @param read 被除数
	 * @param totals 除数
	 */
	public void isZero(int read,int totals){
		System.out.println(String.format("%d", read * 100 / totals) + "%");
	}
	
	public void isWin() {
		String s = null;
		boolean flag = null != s & isok(); 
		System.out.println(flag);
	}
	public boolean isok(){
		System.out.println("====");
		return true;
	}
}
