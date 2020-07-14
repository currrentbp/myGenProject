package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 八皇后问题
 *
 * @author baopan
 * @createTime 2020/7/13 18:29
 */
public class EightQueens {

    /**
     * 记录八皇后的位置
     * 0-7的数字只能重复一次
     * 而且该数组的每个位置代表了一个二维数组中的一个位置（x：index，y：locals[index]）
     * 计算时需要判断本位置之前的所有位置是否有在同一条斜线上的，斜率为正负1
     */
    private int[] locals = new int[8];//记录八个皇后的位置
    private static int count = 0;//总策略数


    @Test
    public void t2() {
        getQueens(0);
    }

    private void getQueens(int row) {
        if (row == 8) {
//            System.out.println("第"+count+"个方案：");
            print1();
            count++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            locals[row] = i;
            if (isOk(row)) {//是否确定该数
                getQueens(row + 1);
            }
        }
    }

    /**
     * 判断当前行是否ok
     */
    private boolean isOk(int row) {
        if (row >= 8) {
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

            if(locals[i] -i == b1){
                result = false;
                break;
            }
            if(locals[i] + i == b2){
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 打印当前的八皇后位置
     */
    private void print1() {
        StringUtil.printObject(locals);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (locals[i] == j)
                    System.out.print("1 "); //表示皇后位置
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }


    //============       最佳答案    =====================

    @Test
    public void t1() {
        dfs(0);
    }

    static int[] queens = new int[8];


    static void dfs(int row) {
        if (row == 8) {
            count++;
//            System.out.println("方案" + count + ":"); //打印方案
            print();
            return;
        }
        for (int column = 0; column < 8; column++) {
            queens[row] = column;
            if (conflict(row) == false)
                dfs(row + 1);
        }
    }

    static boolean conflict(int row) {
        for (int x = 0; x < row; x++) {
            if (queens[x] == queens[row])
                return true;
            if (Math.abs(queens[x] - queens[row]) == (row - x))
                return true;
        }
        return false;
    }

    static void print() { //打印方案的函数
//        StringUtil.printObject(queens);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (queens[i] == j)
                    System.out.print("1 "); //表示皇后位置
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
