package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220927
 */
public class T00494FindTargetSumWays {
    /*
给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
示例 1：
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：
输入：nums = [1], target = 1
输出：1
提示：
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000

解题思路：
1、数学方式：组合
2、动态规划：不会
     */

    @Test
    public void t1() {
        System.out.println(findTargetSumWays(new int[]{1}, 1));
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int fuhao = (length - target) / 2;
        long result = 1L;
        for (int i = target; i > fuhao; i--) {
            result *= i;
        }
        for (int i = 1; i <= target - fuhao; i++) {
            result = result / i;
        }

        return (int) result;
    }
}
