package com.currentbp.Interesting.likou.offer.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20221227
 */
public class T047maxValue {
    /*
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
示例 1:
输入:
[
 [1,3,1],
 [1,5,1],
 [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
解题思路：
1、暴力破解，最多(x+y-2)*2种算法
2、动态规划：max(m,n) = max(max(m-1,n)+(m,n),max(m,n-1)+(m,n))
                    =max( max(m-1,n), max(m,n-1)) +(m,n)
     */

    @Test
    public void t1() {
        int[][] sources = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(maxValue2(sources));
    }

    @Test
    public void t2() {
        int[][] sources = new int[][]{{1, 2},
                {5, 6},
                {1, 1}};
        System.out.println(maxValue(sources));
    }

    /**
     * 超时了
     */
    public int maxValue(int[][] grid) {
        int x = grid.length - 1;
        int y = grid[0].length - 1;
        return maxValue2(grid, x, y);
    }

    private int maxValue2(int[][] grid, int x, int y) {
        if (x == 0 && y == 0) {
            int temp = grid[0][0];
            return temp;
        }
        if (x == 0) {
            int temp = maxValue2(grid, 0, y - 1) + grid[0][y];
            return temp;
        }
        if (y == 0) {
            int temp = maxValue2(grid, x - 1, 0) + grid[x][0];
            return temp;
        }
        int temp1 = maxValue2(grid, x - 1, y);
        int temp2 = maxValue2(grid, x, y - 1);
        int temp3 = Math.max(temp1, temp2) + grid[x][y];
        return temp3;
    }

    public int maxValue2(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[x - 1][y - 1];
    }

}
