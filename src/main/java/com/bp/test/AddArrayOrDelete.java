package com.bp.test;

/**
 * 测试数组的增加
 * @author current_bp
 * @createTime 20160620
 *
 */
public class AddArrayOrDelete {

	public static void main(String[] args) {
		String[] a = new String[4];
		String[] b = new String[2];
		AddArrayOrDelete add = new AddArrayOrDelete();
		a[0] =""+10;
		a[1] = "11";
		a[2] = "23";
		a[3] = "5";
		
		b[0]="44";
		b[1]="66";
		
		System.out.println("a:"+a);
		add.useArray(a);
		
		//从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
		System.arraycopy(b, 0, a, 0, 2);//不能超过原本的数组长度
		
		System.out.println("a:"+a);
		add.useArray(a);
		System.out.println("b:"+b);
		add.useArray(b);
		
	}
	
	public void useArray(String [] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}
