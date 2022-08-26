package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220823
 */
public class T0070ClimbStairs {
    /*
假设你正在爬楼梯。需要 n阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例 1：
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
提示：
1 <= n <= 45
     */
    /*
    标签：动态规划
本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
所以我们得到公式 dp[n] = dp[n-1] + dp[n-2]
同时需要初始化 dp[0]=1 和 dp[1]=1
时间复杂度：O(n)
     */
    @Test
    public void t1() {
        StringUtil.printObject(climbStairs(3));
    }

    public int climbStairs1(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public int climbStairs(int n) {
        if (n <=2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }
}
