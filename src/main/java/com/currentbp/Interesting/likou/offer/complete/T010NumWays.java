package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/31 18:28
 */
public class T010NumWays {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
示例 1：
输入：n = 2
输出：2
示例 2：
输入：n = 7
输出：21
示例 3：
输入：n = 0
输出：1
提示：
0 <= n <= 100

注意：本题的LeetCode测试用例有问题，44时错误
     */

    @Test
    public void t1() {
//        StringUtil.printObject(numWays(1));
//        StringUtil.printObject(numWays(2));
//        StringUtil.printObject(numWays(3));
//        StringUtil.printObject(numWays(4));
//        StringUtil.printObject(numWays(5));
//        StringUtil.printObject(numWays(6));
        StringUtil.printObject(numWays(7));
        StringUtil.printObject(numWays(44));
    }

    public int numWays2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return numWays2(n - 1) + numWays2(n - 2);
    }

    public long numWays(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 1;
        }

        long result = 0;

        long first = 1;
        long second = 2;
        final int MOD = 1000000007;
        for (int i = 3; i <= n; i++) {
            result = first + second;
//            System.out.println("first:" + first + " second:" + second + " result:" + result);
            first = second;
            second = result % MOD;
        }

        return second;
    }
}
