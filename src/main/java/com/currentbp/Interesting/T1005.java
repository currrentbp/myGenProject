package com.currentbp.Interesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.currentbp.util.all.MathUtil;

/**
 * 这一题不明白什么意思。。。。。
 * 题意：被淹没区域从坐标原点开始呈圆形扩散，每年淹没50个单位的面积
       要求输入点的坐标，求多少年后那个点会被淹没
 * @author current_bp
 * @createTime 20160627
 *
 */
public class T1005 {
/*
2
1.0 1.0
25.0 0.0
 */
/*
Property 1: This property will begin eroding in year 1.
Property 2: This property will begin eroding in year 20.
END OF OUTPUT.
 */
	public int num = 0;
	public List<List> coordinates = new ArrayList<List>();
	public List<Integer> result = new ArrayList();
	
	public void init(){
		Scanner sc = new Scanner(System.in);
		
		num = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<num;i++){
			String co = sc.nextLine();
			String[] co1 = co.split(" ");
			List<String> co2 = new ArrayList<String>();
			co2.add(0,co1[0]);
			co2.add(1,co1[1]);
			
			coordinates.add(i,co2);
		}
	}
	
	public void calculation(){
		for(int i=0;i<coordinates.size();i++){
			for(int j=1;;j++){
				float juli = juli(Float.parseFloat(coordinates.get(i).get(0).toString()),
						Float.parseFloat(coordinates.get(i).get(1).toString()));
				if(3.1415*juli*juli/2.0 -50 * j <0){
					result.add(i,Integer.parseInt(""+j));
					break;
				}
			}
		}
	}
	
	public void printResult(){
		System.out.println("result:"+result);
	}
	
	public float juli(float x,float y){
		return MathUtil.distanceFromTwoPlace(x, y);
	}
	
	
	public static void main(String[] args) {
		T1005 t = new T1005();
		t.init();
		t.calculation();
		t.printResult();
	}
}
