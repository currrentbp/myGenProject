package com.bp.Interesting;

import java.util.ArrayList;
import java.util.List;

public class T1012_2 {

	// 循环杀人案件
	// 总人数
	public int personNum = 0;
	// 每次击毙的是第m人
	public int shotNum = 1;
	// 剩余人
	public int[] persons;
	// 杀人顺序
	public List<Integer> shotOrder = new ArrayList<Integer>();

	public T1012_2() {
	}

	public T1012_2(int personNum, int shotNum) {
		this.personNum = personNum;
		if (shotNum == 1) {
			throw new RuntimeException("怎么可能见人就杀啊？扯淡。。。。。");
		}
		this.shotNum = shotNum;
	}

	/**
	 * 初始化最开始的人数，和排序
	 */
	public void init() {
		persons = new int[personNum];
		for (int i = 1; i <= personNum; i++) {
			persons[i - 1] = i;
		}
	}

	public void calculation() {
		for (int i = 1; i < personNum; i++) {// 需要杀几次人
			killPonsen(shotNum);
		}
	}

	private void killPonsen(int killedNum) {
		// persons
		boolean found = false;
		int i = 0;
		int personId = 0;
		int[] newPersons = new int[persons.length - 1];
		int j = 0;
		while (!found || j < persons.length - 1) {// 如果没有找到，或者没有循环完下次的排队顺序，就一直循环
			if (i + 1 == killedNum && !found) {// 第一次找到人
				personId = persons[i % persons.length];
				found = true;
			}

			if (i >= killedNum && j < persons.length - 1) {
				int x = i % (persons.length);
				// System.out.println("x:"+x);
				newPersons[j] = persons[x];
				j++;
			}

			i++;
		}
		shotOrder.add(personId);
		for (int z = 0; z < newPersons.length; z++)
			System.out.print(newPersons[z] + " ");
		System.out.println();
		persons = newPersons;
	}

	public void print() {
		System.out.println("shotOrder:");
		System.out.println(shotOrder);
		System.out.print("survive:");
		System.out.println(persons[0]);
	}

	public static void main(String[] args) {
		T1012_2 t = new T1012_2(6, 5);
		t.init();
		t.calculation();
		t.print();//[5, 4, 6, 2, 3]
		// shot in the order 5, 4, 6, 2, 3 and 1 will besaved.
	}

}
