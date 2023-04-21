package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190506
 */
public class T0033 {
    /*
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
     */

    @Test
    public void t1() {
        int[] nums3 = new int[]{3, 1};
        System.out.println(search(nums3, 1));
        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums1, 0));
        int[] nums2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums2, 3));
    }

    public int search(int[] nums, int target) {
        return searchByBinary(nums, target, 0, nums.length - 1);
    }

    public int searchByBinary(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[left] <= nums[middle]) {//左边有序
            if (nums[left] <= target && target < nums[middle]) {
                return searchByBinary(nums, target, left, middle - 1);
            } else {
                return searchByBinary(nums, target, middle + 1, right);
            }
        } else {//右边有序
            if (nums[middle] < target && target <= nums[right]) {
                return searchByBinary(nums, target, middle + 1, right);
            } else {
                return searchByBinary(nums, target, left, middle - 1);
            }
        }
    }

    /*
    官网最佳答案
     */
    public int search2(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        return searchBinary(0,nums.length - 1,nums,target);
    }

    public int searchBinary(int left,int right,int[] nums,int target){
        if(left > right) return -1;
        if(target == nums[left]){
            return left;
        }
        if(target == nums[right]){
            return right;
        }
        if(right - left <= 1){
            return -1;
        }
        if(nums[right] == nums[left] && target != nums[right]){
            return -1;
        }
        if((target < nums[left] && target < nums[right])||(target > nums[left] && target > nums[right])){
            return searchBinary(left+1,right-1,nums,target);
        }else if(target < nums[left] && target > nums[right]){
            return -1;
        }else if(target > nums[left] && target < nums[right]){
            int middle = (left+right) /2;
            if(target > nums[middle]){
                return searchBinary(middle,right,nums,target);
            }else if(target < nums[middle]){
                return searchBinary(left,middle,nums,target);
            }else{
                return middle;
            }
        }else{
            return -1;
        }
    }
}
