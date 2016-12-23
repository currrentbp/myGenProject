package com.bp.Interesting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author current_bp
 * @createTime 20160625
 *
 */
public class T1004 {
	
/*
Description

Larry graduated this year and finally has a job. He's making a lot of money, but somehow never seems to have enough. Larry has decided that he needs to grab hold of his financial portfolio and solve his financing problems. The first step is to figure out what's been going on with his money. Larry has his bank account statements and wants to see how much money he has. Help Larry by writing a program to take his closing balance from each of the past twelve months and calculate his average account balance. 
Input

The input will be twelve lines. Each line will contain the closing balance of his bank account for a particular month. Each number will be positive and displayed to the penny. No dollar sign will be included. 
Output

The output will be a single number, the average (mean) of the closing balances for the twelve months. It will be rounded to the nearest penny, preceded immediately by a dollar sign, and followed by the end-of-line. There will be no other spaces or characters in the output. 
Sample Input
输入的是12个月的消耗费用，求12个月的平均值，要求：精确到两位小数
100.00
489.12
12454.12
1234.10
823.05
109.20
5.27
1542.25
839.18
83.99
1295.01
1.75
Sample Output

$1581.42

 */
	
	public List<BigDecimal> allNums = new ArrayList<BigDecimal>();
	public int months = 0;
	
	public void init(){
		init(12);
	}
	public void init(int months){
		this.months = months;
		Scanner sc = new Scanner(System.in);
		BigDecimal bd = null;
		String num1 = "";
		
		for(int i=0;i<months;i++){
			num1 = sc.nextLine();
			allNums.add(new BigDecimal(num1));
		}
	}
	
	public void calculation(){
		BigDecimal bd1 = new BigDecimal(0);
		for(int i=0;i<months;i++){
			
			bd1 = bd1.add(allNums.get(i));//此处需要返回结果
		}
		//此处的最后一个参数是涉及到小数的省略规则
		System.out.println("avgMoney:"+bd1.divide(new BigDecimal(months),3,BigDecimal.ROUND_HALF_UP));
		//avgMoney:1581.42
	}
	
	public static void main(String[] args) {
		T1004 t = new T1004();
		
		t.init();
		t.calculation();//avgMoney:1581.42
	}

}
