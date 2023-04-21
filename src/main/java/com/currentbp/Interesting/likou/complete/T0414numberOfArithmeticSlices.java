package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/3/31 20:44
 */
public class T0414numberOfArithmeticSlices {
    /*
    如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
    例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
    给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
    子数组 是数组中的一个连续序列。
    示例 1：
    输入：nums = [1,2,3,4]
    输出：3
    解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
    示例 2：
    输入：nums = [1]
    输出：0

    解题：
    1、由于任意两个元素之差是相等的，也就是说本身就是一个等差数组
    1.1、给定一个公差(数组长度)，然后根据公差去排查本次有多少的组合
     */
    @Test
    public void t1() {
        System.out.println(numberOfArithmeticSlices2(new int[]{1, 1, 1, 1}));//3个，也就是说不排除相同等差数列
        System.out.println(numberOfArithmeticSlices(new int[]{1, 1, 1, 1}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return 1;
        }

        int result = 0;
        for (int i = 3; i <= nums.length; i++) {
            result += (nums.length - i + 1);
        }
        return result;
    }

    /*
    官方答案
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}
