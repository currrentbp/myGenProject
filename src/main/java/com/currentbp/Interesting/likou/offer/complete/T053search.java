package com.currentbp.Interesting.likou.offer.complete;

/**
 * @author baopan
 * @createTime 20221223
 */
public class T053search {
    /*
    统计一个数字在排序数组中出现的次数。
     */

    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            if(target == num){
                count++;
            }
        }
        return count;
    }
}
