package com.currentbp.Interesting.likou.struct.complete;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 1/19/2023 9:26 AM
 */
public class T0217containsDuplicate {
    /*
    给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
示例 1：
输入：nums = [1,2,3,1]
输出：true
示例 2：
输入：nums = [1,2,3,4]
输出：false
示例3：
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
     */

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(result.contains(nums[i])){
                return true;
            }else{
                result.add(nums[i]);
            }
        }
        return false;
    }
}
