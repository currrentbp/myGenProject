package com.currentbp.Interesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author current_bp
 * @createTime 20160706
 *
 */
public class T1009 {

/*
7
15 4
100 15
25 2
175 2
25 5
175 2
25 5	
 */
	
	public int lineNum = 0;
	public List<Integer[]> nums = new ArrayList<Integer[]>();
	public List<Integer[]> tar = new ArrayList<Integer[]>();
	
	
	public void init(){
		Scanner sc = new Scanner(System.in);
		lineNum = Integer.parseInt(sc.nextLine());
		Integer[] oneNum = null;
		for(int i=0;i<lineNum;i++){
			String[] s = sc.nextLine().split(" ");
			oneNum = new Integer[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])};
			nums.add(oneNum);
		}
	}
	public void calculation(){
		
	}
	public static void main(String[] args) {
		T1009 t = new T1009();
//		t.init();
		if(new Integer(1) != null){
			System.out.println("============");
		}else{
			System.out.println("=======++++++++");
		}
	}
}
