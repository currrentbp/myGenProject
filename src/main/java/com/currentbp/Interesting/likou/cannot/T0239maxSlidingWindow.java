package com.currentbp.Interesting.likou.cannot;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/28 20:54
 */
public class T0239maxSlidingWindow {
    /*
给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
示例 1：
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：
输入：nums = [1], k = 1
输出：[1]

解题思路：
1、暴力计算：超时了
     */

    @Test
    public void t1() {
        StringUtil.printObject(maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        StringUtil.printObject(maxSlidingWindow1(new int[]{1}, 1));
    }

    /*
    超时了
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null) {
            return nums;
        }
        if (nums.length <= k) {
            int maxValue = getMax(nums, 0, nums.length - 1);
            return new int[]{maxValue};
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            result[i] = getMax(nums, i, i + k - 1);
        }

        return result;
    }

    private int getMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (; left <= right; left++) {
            max = Math.max(max, nums[left]);
        }
        return max;
    }
}
