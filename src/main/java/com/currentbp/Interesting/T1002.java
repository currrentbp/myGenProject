package com.currentbp.Interesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.currentbp.util.all.StringUtil;

/**
 * 
 * @author current_bp
 * @createTime 20160624
 *
 */
public class T1002 {

	/*
A, B, and C map to 2 
D, E, and F map to 3 
G, H, and I map to 4 
J, K, and L map to 5 
M, N, and O map to 6 
P, R, and S map to 7 
T, U, and V map to 8 
W, X, and Y map to 9 
即：这些字母分别表示这些数字
	 */
	
	/*
12
4873279
ITS-EASY
888-4567
3-10-10-10
888-GLOP
TUT-GLOP
967-11-11
310-GINO
F101010
888-1200
-4-8-7-3-2-7-9-
487-3279

Sample Output...这个结果不对,缺少了一些数据
310-1010 2
487-3279 4
888-4567 3
需要输入这些数字，得到结果
	 */
	private int num ;
	private List<String> allNums = new ArrayList<String>();
	private Map<String,Integer> newNum = new HashMap<String,Integer>();
	private Map<String,Integer> newNum1 = new HashMap<String,Integer>();
	private Map<String,Integer> relation = new HashMap<String,Integer>();
	
	{
		relation.put("A", 2);
		relation.put("B", 2);
		relation.put("C", 2);
		relation.put("D", 3);
		relation.put("E", 3);
		relation.put("F", 3);
		relation.put("G", 4);
		relation.put("H", 4);
		relation.put("I", 4);
		relation.put("J", 5);
		relation.put("K", 5);
		relation.put("L", 5);
		relation.put("M", 6);
		relation.put("N", 6);
		relation.put("O", 6);
		relation.put("P", 7);
		relation.put("R", 7);
		relation.put("S", 7);
		relation.put("T", 8);
		relation.put("U", 8);
		relation.put("V", 8);
		relation.put("W", 9);
		relation.put("X", 9);
		relation.put("Y", 9);
	}
	
	public void init(){
		Scanner sc = new Scanner(System.in);
		num = Integer.parseInt(sc.nextLine()); 
		
		for(int i=0;i<num;i++){
			allNums.add(sc.nextLine());
		}
		
	}
	
	public void arrange(){
		changeCharacterToNum();
		arrangeFormat();
		
	}
	
	private void arrangeFormat() {
		for(int i=0;i<allNums.size();i++){
			String s1 = allNums.get(i);
			if(null == newNum.get(s1)){
				newNum.put(s1, 1);
			}else{
				int j = newNum.get(s1);
				newNum.put(s1, ++j);
			}
		}
		
		Iterator<String> itor =  newNum.keySet().iterator();
		while(itor.hasNext()){
			String s1 = itor.next();
			newNum1.put(StringUtil.insertSomethingToWhere(s1, "-", 3), newNum.get(s1));
		}
	}

	private void changeCharacterToNum() {
		//去除特殊字符
		for(int i=0;i<num;i++){
			String s1 = allNums.get(i); 
			s1 = StringUtil.getStringWithOutSome(s1, "-");
			allNums.set(i, s1);
		}
		
		//字符转化为数字
		for(int i=0;i<num;i++){
			String s1 = allNums.get(i);
			StringBuffer s11 = new StringBuffer();
			
			for(int j=0;j<s1.length();j++){
				String s2 = ""+s1.charAt(j);
				String ssss = "";
				Integer s22 = relation.get(s2);
				
				if(null == s22){
					ssss = s2;
				}else{
					ssss = s22.toString();
				}
				s11.append(ssss);
				
			}
			allNums.set(i, s11.toString());
		}
		System.out.println("allNums:"+allNums);
	}

	public void printResult(){
		System.out.println("newNum1:"+newNum1);
		/*newNum1:{
		310-4466=1, 
		888-4567=3, 
		888-1200=1, 
		967-1111=1, 
		487-3279=4, 
		310-1010=2}
		*/
	}
	
	
	
	
	
	public static void main(String[] args) {
		T1002 t = new T1002();
		t.init();
		t.arrange();
		t.printResult();
	}
}
