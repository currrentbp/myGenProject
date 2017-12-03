package com.currentbp.Interesting.BeiJin;

/**
 * 动态规划
 *
 * @author current_bp
 * @createTime 20170913
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        String s = "aaabbbbbbaaasss";
        if (s.length() <= 1) //字符长度小于等于1,直接输出
            System.out.println(s);
        int maxLength = 0;
        int start = 0;//记录最长回文串的开始位置
        int[][] dp = new int[s.length()][s.length()];//二维数组,用于状态转移
        for (int i = 0; i < s.length(); i++) {//初始化能保证[i,i]第i个位置到第i个位置即单个字符一定是回文串，如果[i,i+1]也等的话也一并初始化
            dp[i][i] = 1;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }
        for (int l = 3; l <= s.length(); l++) {//遍历所有的子串长度
            for (int i = 0; i <= s.length() - l; i++) {//遍历所有长度的起始位置
                int j = i + l - 1;//那么计算出子串的结束位置就该是它了
                if (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {//对每个子串向前回溯,如果当前的起止位置字符相等并且向里缩进的子串是回文串，那么当前的起止串一定也是回文串
                    dp[i][j] = 1;//当前的起止串标记为回文串
                    maxLength = l;//记录最大长度(如果有更长的，之前的就会被覆盖)
                    start = i;//记录每个长度的起始位置
                }
            }
        }
        if (maxLength >= 2)
            System.out.println(s.substring(start, maxLength));
        else
            System.out.println("没有最长回文！！！");
    }
}
