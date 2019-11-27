package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20191118
 */
public class T00041 {
    /*
    给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

     */

    @Test
    public void t1() {
        int i = firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9});
    }

    public int firstMissingPositive(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 1;
        }
        Set<Integer> keys = new HashSet<>(nums.length);
        int max = 0;
        for (int currentNum : nums) {
            if (currentNum <= 0) {
                continue;
            }
            keys.add(currentNum);
            if (max < currentNum) {
                max = currentNum;
            }
        }
        int maxNum = max == Integer.MAX_VALUE ? Integer.MAX_VALUE : max + 1;
        for (int i = 1; i <= maxNum; i++) {
            if (!keys.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    /*
    最佳答案
     */
    public int firstMissingPositive1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        for(int i=0;i<len;i++){
            while(nums[i] > 0 && nums[i]<=len && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }

        for(int i=0;i<len;i++){
            if(nums[i] != i+1) {
                return i+1;
            }
        }

        return len+1;
    }
}
