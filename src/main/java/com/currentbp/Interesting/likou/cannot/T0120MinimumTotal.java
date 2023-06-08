package com.currentbp.Interesting.likou.cannot;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220902
 */
public class T0120MinimumTotal {
    /*
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
那么下一步可以移动到下一行的下标 i 或 i + 1 。
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
    public void t1() {
        List<List<Integer>> tri = Lists.newArrayList(Lists.newArrayList(2), Lists.newArrayList(3, 4),
                Lists.newArrayList(6, 5, 7), Lists.newArrayList(4, 1, 8, 3));
        System.out.println(minimumTotal(tri));
    }
    @Test
    public void t2() {
        List<Integer>t1 = new ArrayList<>();
        t1.add(-10);
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(t1);
        System.out.println(minimumTotal(tri));
    }

    public int minimumTotal(List<List<Integer>> triangles) {
        int[] temp = new int[1];
        temp[0] = triangles.get(0).get(0);
        for (int flow = 1; flow < triangles.size(); flow++) {
            List<Integer> currentFlows = triangles.get(flow);
            int[] topFlows = new int[triangles.get(flow - 1).size()];
            System.arraycopy(temp,0,topFlows,0,temp.length);
            temp = new int[currentFlows.size()];

            for (int j = 0; j < currentFlows.size(); j++) {
                //head
                if (j == 0) {
                    temp[0] = currentFlows.get(0) + topFlows[0];
                } else if (j == currentFlows.size() - 1) {//tail
                    temp[temp.length - 1] = currentFlows.get(j) + topFlows[j - 1];
                } else {//middle
                    int min = Math.min(currentFlows.get(j) + topFlows[j - 1], currentFlows.get(j) + topFlows[j]);
                    temp[j] = min;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            min = Math.min(min, temp[i]);
        }
        return min;
    }
}
