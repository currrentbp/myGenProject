package com.currentbp.Interesting.likou.cannot;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 5/3/2023 10:06 PM
 */
public class T0421findMaximumXOR {
    /*
    给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
示例 1：
输入：nums = [3,10,5,25,2,8]
输出：28
解释：最大运算结果是 5 XOR 25 = 28.
示例 2：
输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
输出：127

     */
    @Test
    public void t1(){
        StringUtil.printObject(findMaximumXOR(new int[]{4,6,7}));
//        StringUtil.printObject(findMaximumXOR(new int[]{3,10,5,25,2,8}));
//        StringUtil.printObject(findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
    }


    /*
    超时了
     */
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return 0;
        }

        int max = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                max = Math.max(max,nums[i]^nums[j]);
            }
        }
        return max;
    }
}
