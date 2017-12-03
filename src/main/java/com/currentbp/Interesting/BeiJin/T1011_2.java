package com.currentbp.Interesting.BeiJin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.currentbp.util.all.ListUtil;
import com.currentbp.util.all.MathUtil;
import com.currentbp.util.all.SortUtil;

/**
 *
 * @author current_bp
 * @createTime 20160822
 *
 */
public class T1011_2 {

	// 每行有多少数据
	public List<Integer> lineNums = new ArrayList<Integer>();
	// 每行的所有的数据
	public List<List<Integer>> allNums = new ArrayList<List<Integer>>();
	// 排序后的所有的数据//从大到小排列
	public List<List<Integer[]>> allNumsBysort = new ArrayList<List<Integer[]>>();
	// 每行数字的所有的约数的集合
	public List<List<Integer>> allYueshus = new ArrayList<List<Integer>>();
	// 每行的可能最小的数据集合
	public List<List<Integer>> minNumList = new ArrayList<List<Integer>>();
	// 每行的最小数据
	public List<Integer> minNums = new ArrayList<Integer>();

	// 1、获取所有的数据，
	// 2、排序所有的数据
	// 3、获取每行数据的约数的集合
	// 4、获取每行的可能最小的数据集合
	// 5、获取每行的最小数据
	
	public void proceduce(){
		init();
		sort();
		getAllYueshus();
		getMinNumList();
		getMinNum();
		print();
	}

	/**
	 * 将数据从控制台中获取
	 */
	public void init() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s1 = sc.nextLine();
			if (null == s1 || "".equals(s1) || "eof".equals(s1)) {
				return;
			}
			lineNums.add(Integer.parseInt(s1));
			String s2 = sc.nextLine();
			String[] a2 = s2.split(" ");
			List<Integer> l1 = new ArrayList<Integer>();
			for (int i = 0; i < a2.length; i++) {
				l1.add(Integer.parseInt(a2[i]));
			}
			allNums.add(l1);
		}

	}

	/**
	 * 将数据排序
	 */
	public void sort() {
		for (int i = 0; i < allNums.size(); i++) {
			List<Integer> newNums1 = new SortUtil().bubblSort(allNums.get(i), false);// 降序

			List<Integer[]> newNums2 = new ArrayList<Integer[]>();
			for (int j = 0; j < newNums1.size(); j++) {
				newNums2.add(new Integer[] { newNums1.get(j), 0 });
			}
			allNumsBysort.add(newNums2);
		}

	}

	/**
	 * 获取所有行的所有的约数
	 */
	public void getAllYueshus() {
		// allNums
		for (int i = 0; i < allNums.size(); i++) {
			allYueshus.add(getYueshus(ListUtil.sumNumsFromList(allNums.get(i))));
		}

		// 将小于最大的数以下的所有的公约数全部去掉
		for (int i = 0; i < allNumsBysort.size(); i++) {
			List<Integer> newYueshus = new ArrayList<Integer>();
			for (int j = 0; j < allYueshus.get(i).size(); j++) {
				if (allYueshus.get(i).get(j) >= allNumsBysort.get(i).get(0)[0]) {
					newYueshus.add(allYueshus.get(i).get(j));
				}
			}
			allYueshus.set(i, newYueshus);
		}
	}

	/**
	 * 获取每行的可能最小的数据集合
	 */
	public void getMinNumList() {
		// allYueshus
		for (int i = 0; i < allYueshus.size(); i++) {// 每行的约数
			List<Integer> yueshus = allYueshus.get(i);
			List<Integer> minNumList11 = new ArrayList<Integer>();
			for (int j = 0; j < yueshus.size(); j++) {
				boolean flag = calculation(allNumsBysort.get(i), yueshus.get(j));
				System.out.println("yueshu:"+yueshus.get(j)+" flag:"+flag);
				//minNums,minNumList
				if(flag){
					minNumList11.add(yueshus.get(j));
				}
				
			}
			minNumList.add(minNumList11);
		}
	}
	
	/**
	 * 获取每行的最小数据
	 */
	public void getMinNum(){
		for(int i=0;i<minNumList.size();i++){
			List<Integer>minNums11 = new SortUtil().bubblSort(minNumList.get(i), true);
			minNums.add(minNums11.get(0));
		}
	}

	/**
	 * 将一些排序好的数和公约数计算，看看是否能满足
	 * @param allNumsBysortList
	 * @param yueshu
	 * @return 能否满足
	 */
	private boolean calculation(List<Integer[]> allNumsBysortList, Integer yueshu) {
		boolean result = false;
		
		//1、计算是否满足，此处使用递归
		result = calculation2(allNumsBysortList,yueshu,0,0);
		changeStatus(allNumsBysortList);
		return result;
	}
	
	
	private boolean calculation2(List<Integer[]> allNumsBysortList, Integer yueshu,Integer sum,Integer station) {
		int remainNum = yueshu - sum;
		int newStation = getNoFlagStation(allNumsBysortList,station);
		if(remainNum == 0){//表示这一轮走完了。。
			if(-1 == isHasAnyNum(allNumsBysortList)){//表示这个列表已经没有了需要计算的数据
				return true;
			}else{
				return calculation2(allNumsBysortList, yueshu,0, 0);
			}
		}
		
		int index = newStation;
		//用于判断新位置是否符合要求，不符合要求，就重新获得下一个可以使用的位置
		while(true){
			if(allNumsBysortList.get(index)[1] == 0 && remainNum >= allNumsBysortList.get(index)[0]){
				break;
			}else{
				if(index >= allNumsBysortList.size()){
					return false;
				}
				index++;
			}
		}
		
		if(-1 != index){
			allNumsBysortList.get(index)[1] = 1;//标志为已使用
			int nowNum = allNumsBysortList.get(index)[1];
			boolean flag = calculation2(allNumsBysortList,yueshu,sum + nowNum, index);
			if(!flag){
				allNumsBysortList.get(index)[1] = 0;//如果出错，需要改回
			}
			return flag;
		}else{
			return false;
		}
	}

	private int getNoFlagStation(List<Integer[]> allNumsBysortList, Integer station) {
		int newStation = -1;
		
		if(station >= allNumsBysortList.size()){
			return newStation;
		}
		
		for(int i=station;i < allNumsBysortList.size();i++){
			if(allNumsBysortList.get(i)[1] == 0){
				newStation = i;
				break;
			}
		}
		return newStation;
	}

	
	private int isHasAnyNum(List<Integer[]> allNumsBysortList){
		int result = -1;
		
		for(int i=0;i<allNumsBysortList.size();i++){
			if(allNumsBysortList.get(i)[1] == 0){//表示还有位置是没有使用
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	private void changeStatus(List<Integer[]> allNumsBysortList){
		if(null ==allNumsBysortList || 0 == allNumsBysortList.size()){
			return;
		}
		
		for(int i=0;i<allNumsBysortList.size();i++){
			allNumsBysortList.get(i)[1] = 0;
		}
		
	}

	/**
	 * 根据一个数获取这个数的所有的约数
	 * 
	 * @param sumNums
	 * @return
	 */
	private List<Integer> getYueshus(Integer sumNums) {
		return new MathUtil().allSubmultiple(sumNums);
	}


	/**
	 * 打印数据
	 */
	public void print() {
		System.out.println(lineNums);
		System.out.println(allNums);

		System.out.print("allNumsBysort:");
		for (int i = 0; i < allNumsBysort.size(); i++) {
			System.out.print(allNumsBysort.get(i));
		}
		System.out.println();

		System.out.println("=========================");
		System.out.println(minNums);

	}

	public static void main(String[] args) {
		T1011_2 t = new T1011_2();
		t.proceduce();
	}
/**
7
3 4 5 5 5 5 13	
 */
	
/**
Description
乔治拿来一组等长的木棒，将它们随机地砍断，使得每一节木棍的长度都不超过50个长度单位。
然后他又想把这些木棍恢复到为裁截前的状态，但忘记了初始时有多少木棒以及木棒的初始长度。
请你设计一个程序，帮助乔治计算木棒的可能最小长度。每一节木棍的长度都用大于零的整数表示。
Input
输入包含多组数据，每组数据包括两行。第一行是一个不超过64的整数，表示砍断之后共有多少节木棍。
第二行是截断以后，所得到的各节木棍的长度。在最后一组数据之后，是一个零。
Output
为每组数据，分别输出原始木棒的可能最小长度，每组数据占一行。
Sample Input
9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0

Sample Output
6
5

 */

}