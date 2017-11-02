package com.currentbp.test;


/**
 * 
 * @author current_bp
 * @createTime 20161123
 *
 */
public class FieldAccess {

	public static void main(String[] args) {
		Super sup = new Sub();
		System.out.println(sup.field+" sup=="+sup.getField());
		Sub sub = new Sub();
		System.out.println(sub.field+" sub=="+sub.getField());
		sup.staticMethod();
	}
}


class Super{
	public int field = 0;
	public static int ff = 1;
	public int getField(){
		return field;
	}
	public static void staticMethod(){
		System.out.println("base staticMethod");
	}
}

class Sub extends Super{
	public int field = 1;
	public int getField(){
		return field;
	}
	public static void staticMethod(){
		System.out.println("derived staticMethod");
	}
}
