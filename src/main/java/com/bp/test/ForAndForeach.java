package com.bp.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bp.util.all.RandomUtil;

public class ForAndForeach {

	
	public static void main(String[] args) {
		
		
		ForAndForeach forAndForeach = new ForAndForeach();
		
//		forAndForeach.foreachWithNull();
		
		forAndForeach.foreachSetData();
		
		
	}
	
	
	/**
	 * 测试foreach是否能修改每个对象的某个属性值
	 */
	public void foreachSetData(){
		List<Student> l = new ArrayList<Student>();
		
		l.add(new Student(1,"1"));
		l.add(new Student(2,"2"));
		System.out.println("before : l:"+l);
		
		for (Student s : l) {
			s.setId(s.id+1);
		}
		
		System.out.println("after : l:"+l);
	}
	
	class Student {
		int id;
		String name;
		
		public Student(int id,String name){
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]";
		}
		
	}
	
	/**
	 * 测试foreach的空处理。。。结果表示报空异常
	 */
	public void foreachWithNull(){
		List<String> list = null;
		for(String s: list){
			System.out.println("s:"+s);
		}
	}
	
	/**
	 * 测试for和foreach的性能
	 */
	public void costTimeForAndForeach(){
		int[] some = new int[100000000];//不能再加一个0了，不然超了
		for(int i=0;i<some.length;i++){
			some[i] = RandomUtil.getRandomNum(10);
		}
		
		long sum1 = 0; 
		long time1 = new Date().getTime();
		for(int i=0;i<some.length;i++){
			sum1 = sum1+some[i];
		}
		long time11 = new Date().getTime();
		System.out.println("sum1:"+sum1+" time1:"+(time11-time1));
		
		long sum2 = 0;
		long time2 = new Date().getTime();
		for (int i : some) {
			sum2 = sum2 + i;
		}
		long time22 = new Date().getTime();
		System.out.println("sum2:"+sum2+" time2:"+(time22-time2));
		/*结论：基本上是for 比 foreach 要快，也有偶然情况
		
		===>数量级：100000000
		sum1:450026157 time1:47
		sum2:450026157 time2:49
		
		sum1:450056516 time1:45
		sum2:450056516 time2:46
		
		sum1:450051787 time1:47
		sum2:450051787 time2:49
		
		sum1:449964094 time1:45
		sum2:449964094 time2:46
		
		sum1:449977021 time1:47
		sum2:449977021 time2:46
		
		sum1:450017706 time1:48
		sum2:450017706 time2:46
		
		sum1:449955402 time1:44
		sum2:449955402 time2:48
		
		sum1:449968798 time1:45
		sum2:449968798 time2:47
		
		sum1:449980626 time1:50
		sum2:449980626 time2:51
		
		sum1:449983701 time1:45
		sum2:449983701 time2:50
		
		sum1:450002062 time1:46
		sum2:450002062 time2:48
		
		
		===>数量级：10000000
		sum1:44983001 time1:8
		sum2:44983001 time2:10
		
		sum1:44994113 time1:8
		sum2:44994113 time2:8
		
		
		sum1:45007937 time1:8
		sum2:45007937 time2:9
		
		sum1:44995397 time1:7
		sum2:44995397 time2:10
		
		sum1:44998530 time1:9
		sum2:44998530 time2:9
		
		sum1:45003507 time1:9
		sum2:45003507 time2:11*/
	}


}
