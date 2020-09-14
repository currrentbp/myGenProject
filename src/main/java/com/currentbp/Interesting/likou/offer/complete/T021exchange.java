package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/9/14 21:58
 */
public class T021exchange {
    /*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
示例：
输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
解题思路：
1、将数组分为两种情况
    1.数组是偶数长度，则将前半段的偶数位置的和后半段的奇数位置调换，i+1(偶数),i<==>i+length/2
    2.数组是奇数长度，i+1(偶数),i<==>i+1+length/2
    3.实现起来有问题
2、利用两个数组实现分组然后拼接起来
     */

    @Test
    public void t1() {
        StringUtil.printObject(exchange(new int[]{1, 2, 3}));
        StringUtil.printObject(exchange(new int[]{1, 2, 3, 4}));
        StringUtil.printObject(exchange(new int[]{1, 2, 3, 4, 5}));
        StringUtil.printObject(exchange(new int[]{1, 2, 3, 4, 5, 6}));
        StringUtil.printObject(exchange(new int[]{1, 2, 3, 4, 5, 6, 7}));
        StringUtil.printObject(exchange(new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1}));//预期结果：[3,5,13,1,1,11,11,11  ,5,1,2,16,16,12,18,8]，本题测试用例有问题
    }

    public int[] exchange(int[] nums) {
        if (null == nums || nums.length <=2) {
            return nums;
        }
        int length = nums.length;
        boolean isOdd = length%2 == 1;//奇数
        int mid = !isOdd ? length/2 :(length/2)%2 == 0 ? length/2 :length/2+1;

        for (int i = 0; i < mid; i++) {
            if (i % 2 == 1) {//偶数列
                if(!isOdd) {//偶数长度
                    int temp = nums[i];
                    nums[i] = nums[length - i - 1];
                    nums[length - i - 1] = temp;
                }else{//奇数长度
                    int temp = nums[i];
                    nums[i] = nums[length - i];
                    nums[length - i] = temp;
                }
            }
        }
        return nums;
    }
}
