package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2020/8/30 23:00
 */
public class T003FindRepeatNumber {
    /*
找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，
也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
     */
    @Test
    public void t1(){
        StringUtil.printObject(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
    public int findRepeatNumber(int[] nums) {
        if(null == nums || 0 == nums.length){
            return 0;
        }
        Set<Integer> keys = new HashSet<>();
        for (int num : nums) {
            if(keys.contains(num)){
                return num;
            }else{
                keys.add(num);
            }
        }
        return 0;
    }
}
