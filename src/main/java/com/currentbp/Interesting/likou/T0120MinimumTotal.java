package com.currentbp.Interesting.likou;

import org.junit.Test;

import java.util.List;

/**
 * @author baopan
 * @createTime 20220902
 */
public class T0120MinimumTotal {
    /*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

 

示例 1：

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为11（即，2+3+5+1= 11）。
示例 2：
输入：triangle = [[-10]]
输出：-10
提示：
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
进阶：
你可以只使用 O(n)的额外空间（n 为三角形的总行数）来解决这个问题吗？
     */
    /*
分析：
自底向上递归
min = min(l0+s0,l1+s0,l1+s1,l2+s1,l2+s2,....,lz+sz)
     */
    @Test
    public void t1(){

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return 0;
    }
}
