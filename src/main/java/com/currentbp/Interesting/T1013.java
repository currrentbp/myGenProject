package com.currentbp.Interesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.currentbp.util.all.StringUtil;

/**
 * 
 * @author current_bp
 * @createTime 20161206
 *
 */
public class T1013 {

	// 相等的策略
	List<String> evenStrategy = new ArrayList<String>();
	// 不等的策略
	List<String> upStrategy = new ArrayList<String>();

	int[] coins = new int[11];

	public T1013() {
	}

	public void init() {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		while (count < 3) {
			String strategy = sc.nextLine();
			if (strategy.endsWith("even")) {
				evenStrategy.add(strategy);
			} else {
				upStrategy.add(strategy);
			}
			count++;
		}
	}

	public void calculate() {
		// 先把所有的能确定是真coin给选出来
		for (int i = 0; i < evenStrategy.size(); i++) {
			String[] s = evenStrategy.get(i).split(" ");
			String coin1 = s[0];
			String coin2 = s[1];

			for (int j = 0; j < coin1.length(); j++) {
				int index = StringUtil.letter2Int(coin1.charAt(j)) - 65;
				coins[index] = 1;
			}

			for (int j = 0; j < coin2.length(); j++) {
				int index = StringUtil.letter2Int(coin2.charAt(j)) - 65;
				coins[index] = 1;
			}
		}

		// 查询不能判断真假的coin是否在相等的两堆coin中
		while (true) {
			int index = -1;
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] == 0) {
					index = i;
					break;
				}
			}

			if (index == -1) {
				break;
			}

			for (int i = 0; i < evenStrategy.size(); i++) {
				String evenCoins = evenStrategy.get(i);
				if (evenCoins.contains("" + StringUtil.int2Letter(65 + index))) {
					coins[index] = 1;
					break;
				}
			}

			if (isOnlyOne()) {
				break;
			}
		}
	}

	public boolean isOnlyOne() {
		int count = 0;

		for (int i = 0; i < coins.length; i++) {
			if (coins[i] == 0) {
				count++;
			}
		}
		return count <= 1;
	}

	public void print() {
		for (int i = 0; i < coins.length; i++) {
			System.out.print(" " + coins[i]);
		}
	}

	public static void main(String[] args) {
		T1013 t = new T1013();
		t.init();
		t.calculate();
		t.print();
	}

	/***
	 * Sally Jones has a dozen Voyageur silver dollars. However, only eleven of
	 * the coins are true silver dollars; one coin is counterfeit even though
	 * its color and size make it indistinguishable from the real silver
	 * dollars. The counterfeit coin has a different weight from the other coins
	 * but Sally does not know if it is heavier or lighter than the real coins.
	 * Happily, Sally has a friend who loans her a very accurate balance scale.
	 * The friend will permit Sally three weighings to find the counterfeit
	 * coin. For instance, if Sally weighs two coins against each other and the
	 * scales balance then she knows these two coins are true. Now if Sally
	 * weighs one of the true coins against a third coin and the scales do not
	 * balance then Sally knows the third coin is counterfeit and she can tell
	 * whether it is light or heavy depending on whether the balance on which it
	 * is placed goes up or down, respectively. By choosing her weighings
	 * carefully, Sally is able to ensure that she will find the counterfeit
	 * coin with exactly three weighings.
	 * 
	 * 
	 * 就是说有12个硬币，其中有一个是假的，但是没法知道这个硬币到底是重还是轻， 可以通过3次测量出
	 * 
	 * 1 ABCD EFGH even ABCI EFJK up ABIJ EFGH even
	 * 
	 * K is the counterfeit coin and it is light.
	 */

}
