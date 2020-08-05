package com.currentbp.Interesting.likou.complete;

import com.alibaba.fastjson.JSON;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/2 13:36
 */
public class T00322CoinChange {
    /*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:
输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

解题思路：参考了答案，我的是通过一个个累加的，这个会耗费时间太久，而且栈溢出等情况，需要将加法变成乘法
1、i=amount / coins[index]
2、循环
     */
    @Test
    public void t4() {
        StringUtil.printObject(coinChange3(new int[]{186, 419, 83, 408}, 6249));
    }
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (null == coins || 0 == coins.length) {
            return -1;
        }
        sortCoins(coins);
        path = Integer.MAX_VALUE;
        paths = new ArrayList<>();
        System.out.println("need:" + amount + " coins:" + JSON.toJSONString(coins));

        doCoinChange2(coins, coins.length - 1, 0, amount);
        return path == Integer.MAX_VALUE ? -1 : path;
    }

    private void doCoinChange2(int[] coins, int index, int count, int needAmount) {
        if (0 == needAmount) {
            path = Math.min(count, path);
            System.out.println(JSON.toJSON(p));
            return;
        }
        if (index<0) {
            return;
        }
        int e = needAmount / coins[index];
        for(int k=e;k>=0 && count+e<path;k--){
            p.add(coins[index]+"*"+k);
            doCoinChange2(coins,index-1,count + k,needAmount - coins[index]*k);
            p.remove(p.size()-1);
        }
    }

    @Test
    public void t2() {
        sortCoins(new int[]{2, 5, 10, 1});
    }

    @Test
    public void t1() {
//        StringUtil.printObject(coinChange(new int[]{1, 2, 5}, 11));
//        StringUtil.printObject(coinChange(new int[]{2}, 3));
//        StringUtil.printObject(coinChange(new int[]{1, 2}, 3));
//        StringUtil.printObject(coinChange(new int[]{1}, 0));
//        StringUtil.printObject(coinChange(new int[]{1, 2, 5}, 100));
//        StringUtil.printObject(coinChange(new int[]{1, 2147483647}, 2));
//        StringUtil.printObject(coinChange(new int[]{1, 2,3,4,5,6}, 20));
        StringUtil.printObject(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (null == coins || 0 == coins.length) {
            return -1;
        }
        sortCoins(coins);
        path = Integer.MAX_VALUE;
        paths = new ArrayList<>();

        System.out.println("need:" + amount + " coins:" + JSON.toJSONString(coins));
        doCoinChange(coins, 0, 0, amount);
        return path == Integer.MAX_VALUE ? -1 : path;
    }

    private int path = Integer.MAX_VALUE;
    private List<Integer> paths = new ArrayList<>();

    private void doCoinChange(int[] coins, int size, long currentMoney, int targetMoney) {
        for (int i = coins.length - 1; i >= 0; i--) {
            if (path != Integer.MAX_VALUE) {
                return;
            }
            paths.add(coins[i]);
            if (size == 20) {
//                System.out.println("cycle size:"+size);
            }
            long tempMoney = currentMoney + coins[i];
            if (tempMoney == targetMoney) {
                path = Math.min(path, size + 1);
                System.out.println("path:" + JSON.toJSONString(paths));
                return;
            } else if (tempMoney > targetMoney) {
                paths.remove(size);
                continue;
            } else {
                doCoinChange(coins, size + 1, tempMoney, targetMoney);
            }
        }
    }

    private void sortCoins(int[] coins) {
        int temp = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = i + 1; j < coins.length; j++) {
                if (coins[j] < coins[i]) {
                    temp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = temp;
                }
            }
        }
//        StringUtil.printObject(coins);
    }

    @Test
    public void t3() {
        StringUtil.printObject(coinChange2(new int[]{186, 419, 83, 408}, 6249));
    }

    int ans = Integer.MAX_VALUE;

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length - 1, coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private List<String> p = new ArrayList<>();
    private void coinChange(int index, int[] coins, int count, int needAmount) {
        if (needAmount == 0) {
            ans = Math.min(count, ans);
            return;
        }
        if (index < 0) {
            return;
        }
        int i = needAmount / coins[index];
        for (int k = i; k >= 0 && count + k < ans; k--) {
            coinChange(index - 1, coins, count + k, needAmount - k * coins[index]);
        }
    }
}
