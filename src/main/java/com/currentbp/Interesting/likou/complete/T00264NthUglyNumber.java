package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220920
 */
public class T00264NthUglyNumber {

    /*
给你一个整数 n ，请你找出并返回第 n 个 丑数 。
丑数 就是只包含质因数2、3 和/或5的正整数。
示例 1：
输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
示例 2：
输入：n = 1
输出：1
解释：1 通常被视为丑数。
提示：
1 <= n <= 1690
     */
/*
解题思路：
2、3、5分别作为一个指针，
第一个丑数是1，那么第二个丑数就是三个指针和1的乘积的最小值，
c(i) = min(c(i2)*2,c(i3)*3,c(i5)*5);
 */
    @Test
    public void t1() {
        System.out.println(nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int c2 = 1, c3 = 1, c5 = 1;
        for (int i = 2; i <= n; i++) {
            int dp2 = dp[c2] * 2;
            int dp3 = dp[c3] * 3;
            int dp5 = dp[c5] * 5;
            dp[i] = Math.min(Math.min(dp2, dp3), dp5);
            if(dp[i] == dp2){
                c2++;
            }
            if(dp[i] == dp3){
                c3++;
            }
            if(dp[i] == dp5){
                c5++;
            }
        }

        return dp[n];
    }
}
