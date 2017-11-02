package com.currentbp.test;

/**
 * 测试对象传值问题。
 * @author current_bp
 * @time 20160405
 *
 */
public class Duixian {
	public int i = 3;
	
	public static void main(String[] args) {
		Duixian t1 = new Duixian();
		Duixian t2 = new Duixian();
		
		//表示在方法的参数中传输一个对象时，该对象中的一些值被改变可以，但是该对象的地址不会被修改。
		t1.createDuixiang(t2);
		System.out.println(t2.i);
	}
	
	public void createDuixiang(Duixian t)
	{
//		t.i = 4;
		//不能修改的原因是：该对象是局部对象，一旦这个区域执行完了，该对象会被释放。除非是return出去。
		Duixian t4 = new Duixian();
		t4.i = 7;
		t = t4;
	}

}
