package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20201122
 */
public class T0054spiralOrder {
    /*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    @Test
    public void t1() {
        StringUtil.printObject(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<int[]> directory = new ArrayList<>();//方向
        int index = 0;//标记方向
        directory.add(new int[]{0, 1});
        directory.add(new int[]{1, 0});
        directory.add(new int[]{0, -1});
        directory.add(new int[]{-1, 0});
        int left = 0, right = matrix[0].length - 1, top = 0, down = matrix.length - 1;//边界
        int startX = 0, startY = 0;//当前位置的坐标
        while (true) {
            if (top > down || left > right) {
                break;
            }
            while (true) {
                int[] dir = directory.get(index / 4);
                if (top <= startX && startX <= down && left <= startY && startY <= right) {
                    result.add(matrix[startX][startY]);
                    startX = startX + dir[0];
                    startY = startY + dir[1];
                } else {
                    startX = startX - dir[0];
                    startY = startY - dir[1];
                    switch (index / 4) {
                        case 0:
                            top++;
                            break;
                        case 1:
                            right--;
                        case 2:
                            down++;
                        case 3:
                            left++;
                            break;
                    }
                    index++;
                    startX = startX + directory.get(index / 4)[0];
                    startY = startY + directory.get(index / 4)[1];
                    break;
                }
            }
        }
        return result;
    }
}
