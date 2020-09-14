package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.ListUtil;
import org.junit.Test;

public class T0064MinPathSum {
    /*
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
解题思路：
1、使用一个中间数组，保存这个位置和起始位置的最小值
     */
    @Test
    public void t1() {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
    @Test
    public void t2() {
        System.out.println(minPathSum(new int[][]{
                {0,2,2,6,4,1,6,2,9,9,5,8,4,4},
                {0,3,6,4,5,5,9,7,8,3,9,9,5,4},
                {6,9,0,7,2,2,5,6,3,1,0,4,2,5},
                {3,8,2,3,2,8,8,7,5,9,6,3,4,5},
                {4,0,1,3,9,2,0,1,6,7,9,2,8,9},
                {6,2,7,9,0,9,5,2,7,5,1,4,4,7},
                {9,8,3,3,0,6,8,0,8,8,3,5,7,3},
                {7,7,4,5,9,1,5,0,2,2,2,1,7,4},
                {5,1,3,4,1,6,0,4,3,8,4,3,9,9},
                {0,6,4,9,4,1,5,5,4,2,5,7,4,0},
                {0,1,6,6,4,9,2,7,8,2,1,3,3,7},
                {8,4,9,9,2,3,8,6,6,5,4,1,7,9}}));
    }

    public int minPathSum(int[][] grid) {
        if(null == grid || 0 == grid.length || 0== grid[0].length){
            return 0;
        }
        int[][] minResult = new int[grid.length][grid[0].length];
        //初始化
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                minResult[y][x] = -1;
            }
        }
        minResult[0][0] = grid[0][0];


        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                calculateCell(grid, x, y, minResult);
            }
        }
        ListUtil.printList(grid);
        System.out.println();
        ListUtil.printList(minResult);
        return minResult[grid.length - 1][grid[0].length - 1];
    }

    private int[] xDir = new int[]{0, -1, 0, 1};
    private int[] yDir = new int[]{-1, 0, 1, 0};

    private void calculateCell(int[][] grid, int x, int y, int[][] minResult) {
        int minValue = Integer.MAX_VALUE;
        int xMaxLength = grid[0].length;
        int yMaxLength = grid.length;
        int currentValue = grid[y][x];
        for (int i = 0; i < 4; i++) {
            System.out.println("x:"+(x+xDir[i])+" y:"+(y+yDir[i]));
            if (x + xDir[i] >= xMaxLength || 0 > x + xDir[i]) {
                continue;
            }
            if (y + yDir[i] >= yMaxLength || 0 > y + yDir[i]) {
                continue;
            }
            int beforeValue = minResult[y + yDir[i]][x + xDir[i]];
            if (beforeValue >= 0) {
                minValue = Math.min(minValue, currentValue + beforeValue);
            }
        }
        minResult[y][x] = minValue == Integer.MAX_VALUE ? currentValue : minValue;
    }
}
