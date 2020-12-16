package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
解题思路：
1、从后往前遍历，如果遇到nums[i] = 0，就找i前面的元素j，使得nums[j] > i - j。如果找不到，则不可能跳跃到num[i+1]，返回false。
     */

    @Test
    public void t1() {

//        StringUtil.printObject(canJump(new int[]{2, 0, 0, 0, 2, 0, 0, 0}));
//        StringUtil.printObject(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
//        StringUtil.printObject(canJump(new int[]{2, 5, 0, 0}));
//        StringUtil.printObject(canJump(new int[]{2, 3, 1, 1, 4}));
//        StringUtil.printObject(canJump(new int[]{3, 2, 1, 0, 4}));
//        StringUtil.printObject(canJump(new int[]{0, 1}));
        StringUtil.printObject(canJump(new int[]{2, 0, 0}));
//        StringUtil.printObject(canJump(new int[]{4, 0, 2, 2, 2, 1, 0, 1, 4, 2, 1, 0}));
//        StringUtil.printObject(canJump(new int[]{0}));
    }

    private boolean canJump(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                if (i - 1 < 0) {
                    return false;
                }
                boolean flag = false;//能找到nums[j] > i - j
                for (int j = i - 1; j >= 0; j--) {
                    if(nums[j] >= i - j && i==nums.length-1){
                        flag = true;
                    }
                    if (nums[j] > i - j) {
                        flag = true;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 官方评论第一个解题思路
     */
    public boolean canJump3(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }


    /*
    我的第一版方案
     */
    public boolean canJump2(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }
        return doEach2(nums, 0);
    }

    private boolean doEach2(int[] nums, int currentIndex) {
        if (currentIndex >= nums.length - 1) {
            return true;
        }
        if (nums[currentIndex] == 0) {
            return false;
        }

        for (int useStep = nums[currentIndex]; useStep > 0; useStep--) {
            boolean result = doEach2(nums, currentIndex + useStep);
            if (result) {
                return true;
            }
        }
        return false;
    }


}
