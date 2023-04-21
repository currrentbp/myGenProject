package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/7/24 16:10
 */
public class T0221 {
    /*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4

解题思路：
如果有一个面积为n平方的则需要计算是否存在面积为（n+1）平方的位置
     */

    @Test
    public void t1() {
        char[][] ints1 =
                {
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '1', '1', '1'}
                };
        char[][] ints2 =
                {
                        {'0', '1'}
                };
        int i = maximalSquare(ints1);
        StringUtil.printObject(i);
    }

    public int maximalSquare(char[][] matrix) {
        if(null == matrix || 0 == matrix.length){
            return 0;
        }
        int result = 0, needLength = 1;
        int xMax = matrix[0].length, yMax = matrix.length;
        if (null == matrix || 0 == matrix.length) {
            return result;
        }
        for (int x = 0; x < xMax; x++) {
            for (int y = needLength - 1; y < yMax; y++) {
                if (isOk(matrix, x, y, needLength)) {
                    result = needLength * needLength;
                    x = needLength-1;
                    needLength++;
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 以(x,y)为正方形的右下角，判断是否存在needLength的长度的正方形
     */
    private boolean isOk(char[][] matrix, int x, int y, int needLength) {
        int xMax = matrix[0].length, yMax = matrix.length;
        for (int i = x; i < xMax; i++) {
            for (int j = y; j < yMax; j++) {
                boolean m = getM(matrix, i - needLength + 1, j - needLength + 1, i, j);
                if (m) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean getM(char[][] matrix, int fX, int fY, int sX, int sY) {
        print(matrix,fX,fY,sX,sY);
        for (int i = fX; i <= sX; i++) {
            for (int j = fY; j <= sY; j++) {
                if (matrix[j][i] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    private void print(char[][] matrix, int fX, int fY, int sX, int sY){
        for (int i = fX; i <= sX; i++) {
            for (int j = fY; j <= sY; j++) {
                System.out.print(matrix[j][i]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
