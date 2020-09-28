package com.currentbp.test.javaBaseTest;

/**
 * 测试对象传值问题。
 * @author Administrator
 *
 */
public class TestDuixian {
	public int i = 3;
	
	public static void main(String[] args) {
		TestDuixian t1 = new TestDuixian();
		TestDuixian t2 = new TestDuixian();
		
		//表示在方法的参数中传输一个对象时，该对象中的一些值被改变可以，但是该对象的地址不会被修改。
		t1.createDuixiang(t2);
		System.out.println(t2.i);
	}
	
	public void createDuixiang(TestDuixian t)
	{
//		t.i = 4;
		//不能修改的原因是：该对象是局部对象，一旦这个区域执行完了，该对象会被释放。除非是return出去。
		TestDuixian t4 = new TestDuixian();
		t4.i = 7;
		t = t4;
	}

}
