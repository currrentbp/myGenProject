package com.currentbp.Interesting.likou.offer.complete;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 1/4/2023 4:34 PM
 */
public class T057twoSum {
    /*
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
限制：
1 <= nums.length <= 10^5
1 <= nums[i]<= 10^6

     */

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return nums;
        }

        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            all.add(num);
        }
        for (int num : nums) {
            int temp = target-num;
            if(all.contains(temp)){
                return new int[]{num,temp};
            }
        }
        return null;
    }
}
