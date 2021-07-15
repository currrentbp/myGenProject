package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20201216
 */
public class T0074searchMatrix {
    /*
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
输出：true
示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
输出：false
示例 3：
输入：matrix = [], target = 0
输出：false

     */

    @Test
    public void t1() {
        StringUtil.printObject(searchMatrix(
                new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 12
        ));

//        StringUtil.printObject(searchMatrix(new int[][]{{1}}, 0));
        StringUtil.printObject(searchMatrix(new int[][]{{1, 1}}, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || 0 == matrix.length) {
            return false;
        }
        int start = 0, end = matrix[0].length-1;
        for (int levelIndex = 0; levelIndex < matrix.length; levelIndex++) {
            for (int currentIndex = start; currentIndex <= end; currentIndex++) {
                if(matrix[levelIndex][currentIndex] == target){
                    return true;
                }
                if(matrix[levelIndex][currentIndex]>target){
                    end = currentIndex;
                    break;
                }
            }
        }


        return false;
    }
}
