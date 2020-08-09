package com.currentbp.Interesting.likou.cannot;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20191216
 */
public class T00200 {
    /*
    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
     */
    @Test
    public void t1() {

//        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int num = numIslands(grid);
        System.out.println(num);
    }

    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }

        char[] chars = grid[0];
        boolean[][] flags = new boolean[grid.length][chars.length];
        int num = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < chars.length; x++) {
                char current = grid[y][x];
                if (!flags[y][x] && '1' == current) {
                    num++;
                    mark(grid, flags, x, y);
                }
                if ('0' == current) {
                    flags[y][x] = true;
                }
            }
        }

        return num;
    }

    private void mark(char[][] grid, boolean[][] flags, int x, int y) {
        char[] chars = grid[0];
        if (x < 0 || x >= chars.length) {
            return;
        }
        if (y < 0 || y >= grid.length) {
            return;
        }

        if (!flags[y][x]) {//没有被标记
            if ('1' == grid[y][x]) {
                flags[y][x] = true;
                //up
                mark(grid, flags, x, y - 1);
                //left
                mark(grid, flags, x - 1, y);
                //right
                mark(grid, flags, x + 1, y);
                //down
                mark(grid, flags, x, y + 1);
            } else {//将0的标记
                flags[y][x] = true;
            }
        }
    }
}
