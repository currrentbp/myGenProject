package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

public class T0096NumTrees {
    /*
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
示例 1：
输入：n = 3
输出：5
示例 2：
输入：n = 1
输出：1
提示：
1 <= n <= 19
     */
    /*
解析：
ri = rl * rr
以i为根节点，左树和右树的乘积就是以i为根节点的所有情况
rsum = r0+...+ri+rn
所有情况就是遍历所有数字为根节点的所有情况
     */
    @Test
    public void t1() {
        System.out.println(numTrees(3));
    }

    public int numTrees(int n) {
        if (n <= 1) {
            return n;
        }
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start > end) {
            return 1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int left = numTrees(start, i - 1);
            int right = numTrees(i + 1, end);
            sum = sum + left * right;
        }
        return sum;
    }
}
