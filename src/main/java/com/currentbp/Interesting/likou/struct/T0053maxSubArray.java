package com.currentbp.Interesting.likou.struct;

/**
 * @author baopan
 * @createTime 1/19/2023 9:27 AM
 */
public class T0053maxSubArray {
    /*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组[4,-1,2,1] 的和最大，为6 。
示例 2：
输入：nums = [1]
输出：1
示例 3：
输入：nums = [5,4,-1,7,8]
输出：23

解题思路：
1、使用动态规划：标记法：标记当前位置的最大值，下一个位置时，比较当前位置的值是否比上一个位置大
Max f(x) = max(max f(x-1),n(x))
     */

    public int maxSubArray(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        int sum = 0;
        int ans = nums[0];
        for(int i = 0 ; i < nums.length; i++){
            if(sum > 0){
                sum += nums[i];
            }
            else{
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
