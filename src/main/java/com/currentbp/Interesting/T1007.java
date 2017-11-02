package com.currentbp.Interesting;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.currentbp.sort.MaoPaoSort;
import com.currentbp.sort.SortObject;

public class T1007 {
	
/*
For instance, in the letter sequence ``DAABEC'', this measure is 5, 
since D is greater than four letters to its right and E is greater 
than one letter to its right. 
 */

/*
 The sequence ``AACEDGG'' has only one inversion (E and D)
 ---it is nearly sorted---while the sequence ``ZWQM'' has 6 inversions 
 (it is as unsorted as can be---exactly the reverse of sorted).
 */
	
	
	
/*
Sample Input

10 6
AACATGAAGG
TTTTGGCCAA
TTTGGCCAAA
GATCAGATTT
CCCGGGGGGA
ATCGATGCAT
Sample Output

CCCGGGGGGA
AACATGAAGG
GATCAGATTT
ATCGATGCAT
TTTTGGCCAA
TTTGGCCAAA
 */
	public Map<String,Integer> source = new HashMap<String,Integer>();
	public List<List<Integer[]>> rote = new ArrayList<List<Integer[]>>();
	public List<String> source1 = new ArrayList<String>();
	public int length = 0;
	public int sum = 0;
	
	public MaoPaoSort mps = new MaoPaoSort();
	
	public void init(){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String [] s2 = s1.split(" ");
		length = Integer.parseInt(s2[0]);
		sum = Integer.parseInt(s2[1]);
		
		String s = null;
		for(int i=0;i<sum;i++){
			s = sc.nextLine();
			source.put(s, 0);
			
			rote.add(calculation1(s));
			source1.add(s);
		}
		
//		System.out.println(rote);
	}
	
	public void calculation(){
		for(int i=0;i<sum;i++){
			int sumCount =0;
			int chr = 0;
			List<Integer[]> l1 = rote.get(i);
			sumCount = getLineCount(i);
			source.put(source1.get(i), sumCount);
			sumCount = 0;
			chr =0;
		}
		System.out.println("source:"+source);
	}
	
	//计算一行的度量
	private int getLineCount(int index) {
		int result = 0;
		int chr = 0;//当前字符
		
		for(int i=0;i<rote.get(index).size();i++){
			for(int j=i;j<rote.get(index).size();j++){
				if(i==j){
					continue;
				}
				if(rote.get(index).get(i)[0] > rote.get(index).get(j)[0]){
					result = result + rote.get(index).get(j)[1] * rote.get(index).get(i)[1];
				}
			}
		}
		System.out.println("index:"+index+" result:"+result);
		return result;
	}

	public void printSome(){
		SortObject so = null;
		String s1 = null;
		for(int i=0;i<sum;i++){
			so = new SortObject();
			s1 = source1.get(i);
			so.setKey(source.get(s1));
			so.setValue(s1);
			mps.getSortObjects().add(so);
		}
		
		mps.sort2();
		
		mps.print();
		/*
		 * 
SortObject [key=9, value=CCCGGGGGGA]
SortObject [key=10, value=AACATGAAGG]
SortObject [key=11, value=GATCAGATTT]
SortObject [key=17, value=ATCGATGCAT]
SortObject [key=36, value=TTTTGGCCAA]
SortObject [key=37, value=TTTGGCCAAA]

CCCGGGGGGA
AACATGAAGG
GATCAGATTT
ATCGATGCAT
TTTTGGCCAA
TTTGGCCAAA
		 */
	}
	
	public List<Integer[]> calculation1(String line){
		
		List<Integer[]> result = new ArrayList<Integer[]>();
		Integer[] charAndSum = null;
		int chr = 0;
		int sum1 = 0;
		for(int i=0;i<length;i++){
			if(chr==0 && sum1==0){
				chr = line.charAt(i);
				sum1 = 1;
			}else if(chr != line.charAt(i)){
				charAndSum = new Integer[]{chr,sum1};
				result.add(charAndSum);
				chr = line.charAt(i);
				sum1 = 1;
			}else{
				sum1++;
			}
			
		}
		charAndSum = new Integer[]{chr,sum1};
		result.add(charAndSum);
		for(int i=0;i<result.size();i++){
			System.out.print("result:"+result.get(i)[0]+" ,"+result.get(i)[1]+"  ");
		}
		System.out.println();
		return result;
	}
	
	
	public static void main(String[] args) {
		T1007 t = new T1007();
		t.init();
		t.calculation();
		t.printSome();
		Long time2 = new Date().getTime();
	}
}
