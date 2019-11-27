package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20191119
 */
public class T00042 {
    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

     */
    @Test
    public void t1() {
        int trap = trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trap);
    }

    public int trap(int[] height) {
        int sum = 0;
        for (int index = 0; index < height.length; index++) {
            sum += getLocalTrap(height, index);
        }
        return sum;
    }

    private int getLocalTrap(int[] height, int index) {
        if (index == 0 || height.length - 1 == index) {
            return 0;
        }

        int leftMaxIndex = index - 1;
        int rightMaxIndex = index + 1;
        for (int i = leftMaxIndex; i >= 0; i--) {
            if (height[leftMaxIndex] < height[i]) {
                leftMaxIndex = i;
            }
        }
        for (int i = rightMaxIndex; i < height.length; i++) {
            if (height[rightMaxIndex] < height[i]) {
                rightMaxIndex = i;
            }
        }
        int min = Math.min(height[leftMaxIndex], height[rightMaxIndex]);
        if (min <= height[index]) {
            return 0;
        } else {
            return min - height[index];
        }
    }

    /*
    最佳答案
     */
    public int trap2(int[] height) {
        int size = height.length;
        int left_max = 0, right_max = 0;
        int left = 0, right = size - 1;
        int result = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    result += left_max - height[left];
                }
                left++;
            } else {
                if(height[right] > right_max) {
                    right_max = height[right];
                } else {
                    result += right_max - height[right];
                }
                right--;
            }
        }
        return result;
    }

}
