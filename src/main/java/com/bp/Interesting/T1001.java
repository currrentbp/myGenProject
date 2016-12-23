package com.bp.Interesting;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 * @author current_bp
 * @createTime 20160623
 *
 */
public class T1001 {

	/*
	 * Sample Input
	 * 95.123 12 
	 * 0.4321 20 
	 * 5.1234 15 
	 * 6.7592 9 
	 * 98.999 10 
	 * 1.0100 12
	 * 
	 * Sample Output
	 * 548815620517731830194541.899025343415715973535967221869852721
	 * .00000005148554641076956121994511276767154838481760200726351203835429763013462401
	 * 43992025569.928573701266488041146654993318703707511666295476720493953024
	 * 29448126.764121021618164430206909037173276672
	 * 90429072743629540498.107596019456651774561044010001
	 * 1.126825030131969720661201
	 */

	/*
	 * 主要测试输入n^m=?
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true){
			String nums = sc.nextLine();
			if(!"eof".equals(nums)){
				System.out.println("nums:"+nums);
				int b = Integer.parseInt(nums.split(" ")[1]);
				
				BigDecimal bd1 = new BigDecimal(nums.split(" ")[0]);
				
				System.out.println(bd1.pow(b));
			}else{
				break;
			}
		}
	}

}
