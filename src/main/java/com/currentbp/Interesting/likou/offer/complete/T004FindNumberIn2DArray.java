package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/30 23:07
 */
public class T004FindNumberIn2DArray {
    /*
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。
     */
    @Test
    public void t1() {
        StringUtil.printObject(findNumberIn2DArray(new int[][]{{1,4,7,11,15},
        {2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length ||0 == matrix[0].length){
            return false;
        }

        int index = matrix[0].length-1;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = index; x >= 0; x--) {
                int currentValue = matrix[y][x];
                if (currentValue == target) {
                    return true;
                }
                if (currentValue < target) {
                    index = matrix[0].length >= x + 1 ? matrix[0].length - 1 : x + 1;
                    break;
                }
            }
        }
        return false;
    }
}
