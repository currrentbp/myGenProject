package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.ListUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2020/9/2 22:47
 */
public class T013MovingCount {
    /*
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
    因为3+5+3+8=19。请问该机器人能够到达多少个格子？
示例 1：
输入：m = 2, n = 3, k = 1
输出：3
示例 2：
输入：m = 3, n = 1, k = 0
输出：1
提示：
1 <= n,m <= 100
0 <= k<= 20
     */

    @Test
    public void t1() {
//        StringUtil.printObject(movingCount(2,3,1));
//        StringUtil.printObject(movingCount(3,1,0));
//        StringUtil.printObject(movingCount(16, 8, 4));
        StringUtil.printObject(movingCount(1, 2, 1));
    }

    public int movingCount(int m, int n, int k) {
        int count = 0;
        int[][] map = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (isOk(x, y, k)) {
                    map[x][y] = 1;//表示该点有可能访问，0：表示一定不能访问的点，1：有可能访问的点（有些点是隔离开来的），2：已近标记过的点
                }
            }
        }
        ListUtil.printList(map);
        count = getCount(map);
        return count;
    }

    private int getCount(int[][] map) {
        List<int[]> needSearch = new ArrayList<>();
        needSearch.add(new int[]{0, 0});
        int count = 0;
        for (int index = 0; index < needSearch.size(); index++) {
            int[] currentPoint = needSearch.get(index);
            int x = currentPoint[0];
            int y = currentPoint[1];
            if (map[y][x] == 0) {
                continue;
            }
            if (map[y][x] == 2) {
                continue;
            }
            map[y][x] = 2;
            count++;
            //上
            if (y - 1 >= 0 && map[y - 1][x] == 1) {
                needSearch.add(new int[]{x, y - 1});
            }
            //左
            if (x - 1 >= 0 && map[y][x - 1] == 1) {
                needSearch.add(new int[]{x - 1, y});
            }
            //下
            if (y + 1 < map.length && map[y + 1][x] == 1) {
                needSearch.add(new int[]{x, y + 1});
            }
            //右
            if (x + 1 < map[0].length && map[y][x + 1] == 1) {
                needSearch.add(new int[]{x + 1, y});
            }

        }
        ListUtil.printList(map);
        return count;
    }

    private boolean isOk(int x, int y, int k) {
        int sum = 0;
        while (true) {
            sum += (x % 10);
            x = x / 10;
            if (x == 0) break;
        }
        while (true) {
            sum += (y % 10);
            y = y / 10;
            if (y == 0) break;
        }
        return sum <= k;
    }
}
