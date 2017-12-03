package com.currentbp.Interesting.BeiJin;

/**
 * 关于电话的游戏（专门用于给程序员的）
 * @author current_bp
 * @createTime 20160622
 *
 */
public class TelGame {

	public static void main(String[] args) {
		int[] arr = new int[] {8,2,1,0,3};
		int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
		
		String tel = "";
		
		for(int i: index){
			tel += arr[i];
		}
		
		System.out.println("tel:"+tel);//tel:18013820100
	}
}
