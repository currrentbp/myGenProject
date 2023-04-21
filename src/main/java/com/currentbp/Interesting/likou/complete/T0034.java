package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.ListUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190507
 */
public class T0034 {
    /*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
     */

    @Test
    public void t1(){
        ListUtil.printList(searchRange(new int[]{5,7,7,8,8,10},8));
        ListUtil.printList(searchRange(new int[]{5,7,7,8,8,10},6));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        boolean leftb = false,rightb= false;
        int [] result = new int[]{-1,-1};
        while(left<=right){
            if(!leftb && nums[left] == target){
                result[0] = left;
                leftb = true;
            }
            if(!rightb && nums[right] == target){
                result[1] = right;
                rightb = true;
            }
            if(leftb && rightb){
                break;
            }
            if(!leftb){
                left++;
            }
            if(!rightb){
                right--;
            }
        }
        return result;
    }

    /*
    官网最佳答案
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0){
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        if(nums[left] == target){
            res[0] = left;
            right = nums.length - 1;
            while(left < right){
                int mid = left + (right - left)/2;
                if(nums[mid] == target && nums[mid+1] !=target){
                    left = mid;
                    break;
                }
                if(nums[mid] != target){
                    right = mid;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        if(nums[left] == target){
            res[1] = left;
        }
        return res;
    }
}
