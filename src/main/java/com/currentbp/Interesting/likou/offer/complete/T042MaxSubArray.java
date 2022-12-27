package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210706
 */
public class T042MaxSubArray {
    /*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:连续子数组[4,-1,2,1] 的和最大，为6。

解题思路：
1、写一个矩阵，矩阵的内容就是从一个点到另一个点的和，找出最大的值就行了，其中用了动态规划的思想，利用以前的数据计算现有的值
第二种思路：
1、max(f(n)) = max(mf(n-1)+n,mf(n-1),n)
     */

    @Test
    public void t1() {
        StringUtil.printObject(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 我写的，超时了
     */
    public int maxSubArray(int[] nums) {
        int[] values = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    values[i] = nums[i];
                } else {
                    values[i] = values[i] + nums[index];
                }
                max = max < values[i] ? values[i] : max;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
