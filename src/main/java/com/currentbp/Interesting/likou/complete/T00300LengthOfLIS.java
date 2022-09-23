package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220920
 */
public class T00300LengthOfLIS {
    /*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
提示：
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
进阶：
你能将算法的时间复杂度降低到O(n log(n)) 吗?

解题思路：
如果i的数字比i-n的数字大，则
dp[i] = max(dp[i-n])+1

其中dp[i]表示比前i个数字大的子序列长度
     */
    //todo not work

    @Test
    public void t1() {
        System.out.println(lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS1(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS1(new int[]{7,7,7,7,7,7,7}));
    }

    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        return dp[nums.length - 1];
    }
}
