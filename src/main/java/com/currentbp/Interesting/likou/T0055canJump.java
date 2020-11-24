package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20201124
 */
public class T0055canJump {
    /*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */

    @Test
    public void t1() {
        StringUtil.printObject(canJump(new int[]{2, 5, 0, 0}));
//        StringUtil.printObject(canJump(new int[]{2, 3, 1, 1, 4}));
//        StringUtil.printObject(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }
        return doEach(nums, 0, nums[0]);
    }

    private boolean doEach(int[] nums, int beforeIndex, int useStep) {
        int beforeMaxStep = nums[beforeIndex];
        if (useStep == 0) {
            return false;
        }
        if (beforeIndex + useStep >= nums.length - 1) {
            return true;
        }
        if (nums[beforeIndex + useStep] != 0) {
            return doEach(nums, beforeIndex + beforeMaxStep, nums[beforeIndex + beforeMaxStep]);
        } else {
            return doEach(nums, beforeIndex, useStep - 1);
        }
    }
}
