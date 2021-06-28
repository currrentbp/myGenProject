package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210623
 */
public class T059maxSlidingWindow {

    /*
    给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
提示：
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
     */
    @Test
    public void t1(){
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        StringUtil.printObject(maxSlidingWindow(nums,3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int value = getMax(nums, i, i + k - 1);
            result[i] = value;
        }
        return result;
    }

    private int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int index = start; index <= end; index++) {
            max = Math.max(max, nums[index]);
        }
        return max;
    }


}
