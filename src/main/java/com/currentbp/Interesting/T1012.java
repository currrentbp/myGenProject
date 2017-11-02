package com.currentbp.Interesting;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author current_bp
 * @createTime 20160823
 *
 */
public class T1012 {
	// 循环杀人案件
	// 总人数
	public int personNum = 0;
	// 每次击毙的是第m人
	public int shotNum = 1;
	// 领头人
	public PersonLinkedList firstPerson = null;
	// 结尾人
	public PersonLinkedList tailPerson = null;
	//杀人顺序
	public List<Integer> shotOrder = new ArrayList<Integer>();
	

	public T1012() {
	}

	public T1012(int personNum, int shotNum) {
		this.personNum = personNum;
		if (shotNum == 1) {
			throw new RuntimeException("怎么可能见人就杀啊？扯淡。。。。。");
		}
		this.shotNum = shotNum;
	}

	public synchronized boolean addOnePersonToTail(PersonLinkedList onePerson) {
		boolean result = false;
		if (null == firstPerson && null == tailPerson) {
			firstPerson = onePerson;
			firstPerson.setNextPerson(onePerson);
			firstPerson.setPrePerson(onePerson);

			tailPerson = onePerson;
			tailPerson.setPrePerson(onePerson);
			tailPerson.setNextPerson(onePerson);
		} else {
			onePerson.setNextPerson(firstPerson);
			onePerson.setPrePerson(tailPerson);
			tailPerson.setNextPerson(onePerson);
			firstPerson.setPrePerson(onePerson);
			tailPerson = onePerson;
		}
		result = true;

		return result;
	}
	
	public synchronized boolean deletePerson(int num){
		boolean result = false;
		
		PersonLinkedList onePerson = firstPerson;//
		for(int i=1; i< num;i++){//由于第一个已经获取,故，需要忽略最后一个
			onePerson = onePerson.getNextPerson();
		}
		//添加被杀的人
		int personId = onePerson.getPersonId();
		shotOrder.add(personId);
		//5, 4, 6, 2, 3 and 1
		//[5, 4, 6, 2, 3]
		PersonLinkedList prePerson = onePerson.getPrePerson();
		PersonLinkedList nextPerson = onePerson.getNextPerson();
		
		prePerson.setNextPerson(nextPerson);
		nextPerson.setPrePerson(prePerson);
		firstPerson = nextPerson;
		tailPerson = prePerson;
		
		result = true;
		
		return result;
	}

	/**
	 * 初始化出一个人圈
	 */
	public void init() {
		PersonLinkedList nextPerson1 = null;

		// 从第二个开始
		for (int i = 1; i <= personNum; i++) {
			nextPerson1 = new PersonLinkedList(i);
			addOnePersonToTail(nextPerson1);
		}
	}
	
	/**
	 * 杀人
	 */
	public void shotPersonOnlyOne(){
		for(int i=1;i<= personNum -1 ;i++){
			deletePerson(shotNum);
		}
	}
	
	/**
	 * 打印被杀人的顺序，并打印活着的人
	 */
	public void print(){
		System.out.println(shotOrder);
		System.out.println("only one:"+firstPerson.getPersonId());
	}

	public static void main(String[] args) {
		T1012 t = new T1012(6, 5);
		t.init();
		t.shotPersonOnlyOne();
		t.print();
		//shot in the order 5, 4, 6, 2, 3 and 1 will besaved.
		//[6, 1, 3, 2, 5]
	}

	class PersonLinkedList {
		public int id;

		public PersonLinkedList(int id) {
			this.id = id;
		}

		public PersonLinkedList nextPerson = null;
		public PersonLinkedList prePerson = null;

		public void setNextPerson(PersonLinkedList next) {
			nextPerson = next;
		}

		public void setPrePerson(PersonLinkedList pre) {
			prePerson = pre;
		}

		public PersonLinkedList getNextPerson() {
			return this.nextPerson;
		}

		public PersonLinkedList getPrePerson() {
			return this.prePerson;
		}

		public int getPersonId() {
			return this.id;
		}

	}
	/**
	 * 我要做的是将一个队列有n个人，每第m个人被击毙，需要计算最后死的人的位置
	 */

	/**
	 * The Joseph's problem is notoriously known. For those who are not familiar
	 * with the original problem: from among n people, numbered 1, 2, . . ., n,
	 * standing in circle every mth is going to be executed and only the life of
	 * the last remaining person will be saved. Joseph was smart enough to
	 * choose the position of the last remaining person, thus saving his life to
	 * give us the message about the incident. For example when n = 6 and m = 5
	 * then the people will be executed in the order 5, 4, 6, 2, 3 and 1 will be
	 * saved.
	 * 
	 * Suppose that there are k good guys and k bad guys. In the circle the
	 * first k are good guys and the last k bad guys. You have to determine such
	 * minimal m that all the bad guys will be executed before the first good
	 * guy.
	 * 
	 * Input
	 * 
	 * The input file consists of separate lines containing k. The last line in
	 * the input file contains 0. You can suppose that 0 < k < 14. Output
	 * 
	 * The output file will consist of separate lines containing m corresponding
	 * to k in the input file. Sample Input
	 * 
	 * 3 4 0 Sample Output
	 * 
	 * 5 30
	 */
}
