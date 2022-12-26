package com.currentbp.Interesting.likou.offer.complete;

/**
 * @author baopan
 * @createTime 20221223
 */
public class T053missingNumber {
    /*
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }
}
