package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190111
 */
public class T0011 {
    /*
    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
     */

    //https://leetcode-cn.com/problems/container-with-most-water/
    @Test
    public void t1() {
        Assert.isTrue(49 == maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), "error");
    }

    /*
    暴力算法
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        for (int start = 0, end = height.length - 1; start != end; ) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}
