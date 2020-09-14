package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/9/14 19:00
 */
public class T0051solveNQueens {
    /*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
上图为 8 皇后问题的一种解法。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例：
输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
     */

    @Test
    public void t1(){
        List<List<String>> lists = solveNQueens(4);
        StringUtil.printObject(lists);
    }

    private List<List<String>> allPaths = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        locals = new int[n];
        getQueens(0, n);
        return allPaths;
    }

    /**
     * 记录八皇后的位置
     * 0-7的数字只能重复一次
     * 而且该数组的每个位置代表了一个二维数组中的一个位置（x：index，y：locals[index]）
     * 计算时需要判断本位置之前的所有位置是否有在同一条斜线上的，斜率为正负1
     */
    private int[] locals = null;//记录八个皇后的位置
    private static int count = 0;//总策略数

    private void getQueens(int row, int n) {
        if (row == n) {
            print1(n);
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            locals[row] = i;
            if (isOk(row, n)) {//是否确定该数
                getQueens(row + 1, n);
            }
        }
    }

    /**
     * 判断当前行是否ok
     */
    private boolean isOk(int row, int n) {
        if (row >= n) {
            return true;
        }
        boolean result = true;

        //1、判断同一列是否有两个皇后，有则错误
        //2、判断该位置的斜率为正负1时的斜线上是否有其他皇后，有则错误
        for (int i = 0; i < row; i++) {
            if (locals[i] == locals[row]) {//如果同一列有2个以上的皇后则位置错误
                result = false;
                break;
            }
            //获取截距 ,公式：y = +-1 * x + b，b = y +- x
            int b1 = locals[row] - row;//斜率为正1
            int b2 = locals[row] + row;//斜率为负1

            if (locals[i] - i == b1) {
                result = false;
                break;
            }
            if (locals[i] + i == b2) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 打印当前的八皇后位置
     *
     * @param n
     */
    private void print1(int n) {
        //            System.out.println("第"+count+"个方案：");
        StringUtil.printObject(locals);
        List<String> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                if (locals[i] == j) {
                    System.out.print("1 "); //表示皇后位置
                    temp = temp + "Q";
                } else {
                    System.out.print("0 ");
                    temp = temp + ".";
                }
            }
            System.out.println();
            path.add(temp);
        }
        allPaths.add(path);
    }
}
