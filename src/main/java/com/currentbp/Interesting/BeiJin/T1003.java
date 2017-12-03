package com.currentbp.Interesting.BeiJin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author current_bp
 * @createTime 20160624
 *
 */
public class T1003 {
	
	
/*
	How far can you make a stack of cards overhang a table? 
	If you have one card, you can create a maximum overhang of half a card length. 
	(We're assuming that the cards must be perpendicular to the table.) 
	With two cards you can make the top card overhang the bottom one 
	by half a card length, and the bottom one overhang the table by a third 
	of a card length, for a total maximum overhang of 1/2 + 1/3 = 5/6 card lengths. 
	In general you can make n cards overhang by 1/2 + 1/3 + 1/4 + ... + 1/(n + 1) 
	card lengths, where the top card overhangs the second by 1/2, 
	the second overhangs tha third by 1/3, the third overhangs the fourth by 1/4, 
	etc., and the bottom card overhangs the table by 1/(n + 1). 
	This is illustrated in the figure below.
*/
/*
	也就是说最上面的超出下面的1/2，下面的超出第三个1/3，以此类推....，1/n,
	要求：计算超出M，需要几块card
*/
	
/*
Sample Input

1.00
3.71
0.04
5.19
eof

Sample Output

3 card(s)
61 card(s)
1 card(s)
273 card(s)

cards:[3, 61, 1, 273]
 */
	public List<Float> nums = new ArrayList<Float>();
	public List<Integer> cards = new ArrayList<Integer>();
	
	
	/**
	 * 输入数据
	 */
	public void init(){
		Scanner sc = new Scanner(System.in);
		while(true){
			String s1 = sc.nextLine();
			if("eof".equals(s1)){
				break;
			}else{
				nums.add(Float.parseFloat(s1));
			}
		}
		System.out.println("nums:"+nums);
		System.out.println("init end..");
	}
	
	public void calculation(){
		int result = 0;
		for(int i=0;i<nums.size();i++){
			result = digui(nums.get(i));
			cards.add(result-1);
		}
	}
	
	private int digui(Float length) {
		int x = 2;
		double sum = 0;
		while(true){
			sum = sum + 1.0/x;
			if(sum >= length){
				return x;
			}else{
				x++;
			}
		}
	}

	public void printResult(){
		System.out.println("cards:"+cards);
	}
	public static void main(String[] args) {
		T1003 t = new T1003();
		t.init();
		t.calculation();
		t.printResult();
	}

}
