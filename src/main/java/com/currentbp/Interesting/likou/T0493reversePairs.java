package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 5/6/2023 5:54 PM
 */
public class T0493reversePairs {
    /*
    给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
你需要返回给定数组中的重要翻转对的数量。
示例 1:
输入: [1,3,2,3,1]
输出: 2
示例 2:
输入: [2,4,3,5,1]
输出: 3
解题思路：
1、暴力计算
     */

    @Test
    public void t1() {
        StringUtil.printObject(reversePairs(new int[]{1, 3, 2, 3, 1}));
        StringUtil.printObject(reversePairs(new int[]{2, 4, 3, 5, 1}));
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    result++;
                }
            }
        }

        return result;
    }
}
