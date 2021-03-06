package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.text.MessageFormat;

/**
 * @author baopan
 * @createTime 20201220
 */
public class T0062uniquePaths {
    /*
一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
示例 1：
输入：m = 3, n = 7
输出：28
示例 2：
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 3：
输入：m = 7, n = 3
解题思路：
1、这是一个数学题：C（m+n-2）(m-1)
     */
    @Test
    public void t1() {
//        StringUtil.printObject(uniquePaths(3, 2));
        StringUtil.printObject(uniquePaths(3, 7));
        System.out.println(17*13*2*10*11*2);
    }

    public int uniquePaths(int m, int n) {
        int result = 1;
        int down = m + n - 2;
        int top = m - 1;
        int remain = down - top;
        int max = Math.max(remain, top);
        int min = Math.min(remain, top);
        for (int x = max+1; x <= down; x++) {
            result *= x;
        }
        for (int x = 1; x <= min; x++) {
            result /= x;
        }
        return result;
    }

    @Test
    public void t2(){
        String description = "\uD83D\uDC8C您关注的【{0}】更新啦";
        String fff = MessageFormat.format(description, "[耐克。态动了更新[亲了");
        System.out.println(fff);
    }
}
