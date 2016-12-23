package com.bp.test;


/**
 * 测试final和static的用法
 * 结论：1、证明了final 只是一个对象内不会再修改该值。
 * 		2、static final :全局的而且是不可修改的。
 * @author current_bp
 *
 */
public class FinalAndStatic {
	
	public final int x1 = (int) (Math.random() * 20);
	public static final int x2 = (int) (Math.random() * 20);
	
	public static void main(String[] args) {
		FinalAndStatic tfs1 = new FinalAndStatic();
		FinalAndStatic tfs2 = new FinalAndStatic();
		System.out.println("x1:"+tfs1.x1+" x11:"+tfs2.x1+" x111:"+tfs1.x1+" x1111:"+tfs2.x1);//证明了final 只是一个对象内不会再修改该值。
		System.out.println("x2:"+tfs1.x2+" x12:"+tfs2.x2);//全局的而且是不可修改的。
	}

}
