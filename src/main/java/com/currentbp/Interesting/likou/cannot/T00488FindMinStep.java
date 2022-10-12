package com.currentbp.Interesting.likou.cannot;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220926
 */
public class T00488FindMinStep {
    /*
你正在参与祖玛游戏的一个变种。
在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
你的目标是 清空 桌面上所有的球。每一回合：
从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
如果桌面上所有球都被移除，则认为你赢得本场游戏。
重复这个过程，直到你赢了游戏或者手中没有更多的球。
给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
示例 1：
输入：board = "WRRBBW", hand = "RB"
输出：-1
解释：无法移除桌面上的所有球。可以得到的最好局面是：
- 插入一个 'R' ，使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
- 插入一个 'B' ，使桌面变为 WBBBW 。WBBBW -> WW
桌面上还剩着球，没有其他球可以插入。
示例 2：
输入：board = "WWRRBBWW", hand = "WRBRW"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
- 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
只需从手中出 2 个球就可以清空桌面。
示例 3：
输入：board = "G", hand = "GGGGG"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个 'G' ，使桌面变为 GG 。
- 插入一个 'G' ，使桌面变为 GGG 。GGG -> empty
只需从手中出 2 个球就可以清空桌面。
示例 4：
输入：board = "RBYYBBRRB", hand = "YRBGB"
输出：3
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个 'Y' ，使桌面变为 RBYYYBBRRB 。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
- 插入一个 'B' ，使桌面变为 BB 。
- 插入一个 'B' ，使桌面变为 BBB 。BBB -> empty
只需从手中出 3 个球就可以清空桌面。
提示：
1 <= board.length <= 16
1 <= hand.length <= 5
board 和 hand 由字符 'R'、'Y'、'B'、'G' 和 'W' 组成
桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球
     */
    /*
解题思路：   todo 此题没有完成
1、使用递归，将hand的第一个字符放到
     */

    @Test
    public void t1() {
        System.out.println(findMinStep("WRRBBW", "RB"));
        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
    }

    public int findMinStep(String board, String hand) {
        boolean b = doFindMinStep(board, hand);
        System.out.println("result:" + b);
        return -1;
    }

    public boolean doFindMinStep(String board, String hand) {
        if (hand.length() == 0 && board.length() != 0) {
            return false;
        }
        if (board.length() == 0) {
            return true;
        }
        char c = hand.charAt(0);
        String remainHand = hand.substring(1);
        boolean result = true;
        for (int i = 0; i < board.length(); i++) {
            int i1 = board.indexOf(c);
            //该字符不存在
            if (i1 == -1) {
                String temp = board + c;
                return result && doFindMinStep(temp, remainHand);
            } else {
                //存在，且有多处
                String temp = board.substring(0, i1) + c + board.substring(i1);
                temp = removeThree(temp);
                return result && doFindMinStep(temp, remainHand);
            }
        }
        return result;
    }

    @Test
    public void removeTreeT1() {
        StringUtil.printObject(removeThree("aaaabbbb"));
        StringUtil.printObject(removeThree("aaabbb"));
        StringUtil.printObject(removeThree("aaabb"));
        StringUtil.printObject(removeThree("aabb"));
        StringUtil.printObject(removeThree("aaa1bb"));
        StringUtil.printObject(removeThree("aaa111bb222b"));
        StringUtil.printObject(removeThree("aaa111bb3333"));
        StringUtil.printObject(removeThree("123111332211"));
        StringUtil.printObject(removeThree("1"));
        StringUtil.printObject(removeThree(""));
        StringUtil.printObject(removeThree("111"));
        StringUtil.printObject(removeThree("1112333333322"));
    }

    private String removeThree(String source) {
        int left = 0;
        while (true) {
            if (left >= source.length()) {
                break;
            }
            char leftChar = source.charAt(left);
            int right = left + 1;
            if (right >= source.length()) {
                break;
            }
            while (right < source.length()) {
                if (source.charAt(right) != leftChar) {
                    right--;
                    break;
                } else {
                    if (right == source.length() - 1) {
                        break;
                    }
                    right++;
                }
            }

            if (right - left + 1 >= 3) {
                String leftString = left == 0 ? "" : source.substring(0, left);
                String rightString = right == source.length() - 1 ? "" : source.substring(right + 1);
                source = leftString + rightString;
                left = 0;
            } else {
                if (left == right) {
                    left++;
                } else {
                    left = right;
                }
            }
        }
        return source;
    }
}
