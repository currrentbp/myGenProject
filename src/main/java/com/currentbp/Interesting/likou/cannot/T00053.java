package com.currentbp.Interesting.likou.cannot;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20200311
 */
public class T00053 {
    /*
    题目
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

解法
算出最大的子数组之和

sum 为子序列之和，sum >0 则说明结果有增，则sum 保留当前遍历数字
如果sum <=0,则说明sum对结果无增益效果，需要舍弃，则sum直接更新为当前遍历数字
每次比较sum和ans的大小，将最大值置为ans，遍历结束返回结果
时间复杂度为O(n)
     */

    @Test
    public void t1(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        StringUtil.printObject(maxSubArray(nums));
        int[] nums2 = new int[]{100,-1,-1,-1};
        StringUtil.printObject(maxSubArray(nums2));
    }

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
