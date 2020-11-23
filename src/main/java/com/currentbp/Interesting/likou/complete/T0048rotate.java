package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author baopan
 * @createTime 2020/11/19 12:24
 */
public class T0048rotate {
    /*
给定一个n×n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],
原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
解决方案：
1、（0,0）作为原点按照斜率为-1做对称交换
2、以交换后的矩阵按照中间为对称轴对调
     */

    @Test
    public void t1(){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        StringUtil.printObject(matrix);
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //1、（0,0）作为原点按照斜率为-1做对称交换
        for(int i=0;i<length;i++){
            for(int j=0;j<=i;j++){
                swap(matrix,i,j,j,i);
            }
        }
        //2、以交换后的矩阵按照中间为对称轴对调
        for(int i=0;i<length;i++){
            for(int j=0;j<length/2;j++){
                swap(matrix,i,j,i,length-j-1);
            }
        }
    }

    private void swap(int[][] matrix, int x, int y, int x1, int y1) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[x1][y1];
        matrix[x1][y1] = temp;
    }
}
