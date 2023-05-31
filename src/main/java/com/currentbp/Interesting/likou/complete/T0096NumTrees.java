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
解题思路2：
1、可以先确定根节点，然后在根节点确定的情况下的数量 = 左边情况的数量 * 右边各种情况的数量 。即： allCount = sumI( leftCount * rightCount ),
        I是从1到N的,left+right=length-1
2、其中leftCount的计算过程中，可以确定的是从low->high的队列，也就是说它的排列情况和数字的多少有关，和数字本身无关
3、可以定义一个数组a[i]表示i个数字时有多少种
     */
    @Test
    public void t1() {
        System.out.println(numTrees(3));
    }

    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                if (i - j - 1 < 0) {
                    continue;
                }
                sum = sum + a[j] * a[i - j - 1];
            }
            a[i] = sum;
        }

        return a[n];
    }

    /*
    我的超时了
     */
    public int numTrees1(int n) {
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
