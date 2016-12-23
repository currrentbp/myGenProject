package com.bp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bp.util.all.TimeUtil;


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
		
		
		
//		StringTest st = new StringTest();
//		st.isWin();
		
//		StringTest st = new StringTest();
//		st.sudu();
//		HashMap<String,String> map = new HashMap<String, String>();
//		//测试0是啥。。
//		String path="";
//		path = new String("abcdefABCDEF");
//		System.out.println(path.indexOf(41) );
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
