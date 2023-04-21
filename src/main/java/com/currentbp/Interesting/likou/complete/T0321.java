package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/7/24 19:30
 */
public class T0321 {
    /*
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 
个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
说明: 请尽可能地优化你算法的时间和空间复杂度。
示例 1:
输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:
输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:
输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]

问题分析：
1、fm(k) = f1(i)+f2(k-i)
2、从第一个数组中拿出i个最大的数（按照顺序的），从第二个数组中拿出k-i个最大的数（按照顺序的）
3、组合这两个数组中的数字
     */


    @Test
    public void t1() {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int[] ints = maxNumber(nums1, nums2, 7);
        StringUtil.printObject(ints);
    }

    @Test
    public void t11() {
        int[] nums1 = {2, 2, 0, 6, 8, 9, 6};
        int[] nums2 = {5, 2, 4, 5, 3, 6, 2};
        int[] ints = maxNumber(nums1, nums2, 7);
        StringUtil.printObject(ints);
    }

    @Test
    public void t111() {
        int[] nums1 = {2, 5, 6, 4, 4, 0};
        int[] nums2 = {7, 3, 8, 0, 6, 5, 7, 6, 2};
        int[] ints = maxNumber(nums1, nums2, 15);
        StringUtil.printObject(ints);
    }

    @Test
    public void t1111() {
        int[] nums1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] ints = maxNumber(nums1, nums2, 100);
        StringUtil.printObject(ints);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if ((null == nums1 || 0 == nums1.length) && (null != nums2 && nums2.length <= k)) {
            return nums2;
        }
        if ((null == nums2 || 0 == nums2.length) && (null != nums1 && nums1.length <= k)) {
            return nums1;
        }
        if ((null == nums1 || 0 == nums1.length) && (null == nums2 || 0 == nums2.length)) {
            return null;
        }
        if (nums1.length + nums2.length <= k) {
            return combination(nums1, nums2);
        }

        int n1Length = nums1.length;
        int n2Length = nums2.length;
        int maxLength = Math.max(Math.max(n1Length, n2Length), k);

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            if (i <= n1Length && k - i <= n2Length && i > 0 && k - i >= 0) {//
                int[] n1Max = getMax(nums1, i);
                int[] n2Max = getMax(nums2, k - i);
                int[] combination = combination(n1Max, n2Max);
                result.add(combination);
            }
        }

        int[] maxValue = getMaxValue(result);

        return maxValue;
    }

    private int[] getMaxValue(List<int[]> result) {
        int length = result.get(0).length;

        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            indexs.add(i);
        }
        for (int i = 0; i < length; i++) {//对比的位数
            List<Integer> temp = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < indexs.size(); j++) {//每个排序好的数组
                max = Math.max(max, result.get(indexs.get(j))[i]);
            }
            for (int j = 0; j < indexs.size(); j++) {
                if (max == result.get(indexs.get(j))[i]) {
                    temp.add(indexs.get(j));
                }
            }
            indexs = temp;
            if (indexs.size() == 1) {
                return result.get(indexs.get(0));
            }
        }
        return result.get(indexs.get(0));
    }

    @Test
    public void t3() {
        int[] nums = new int[]{9, 1, 2, 5, 8, 3};
        int[] max = getMax(nums, 7);
        StringUtil.printObject(max);
    }

    /**
     * 获取按照顺序的k个数字组成本数组中最大的值
     */
    private int[] getMax(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (nums.length < k) {
            return nums;
        }
        System.out.println("k:" + k);
        int[] result = new int[k];
        boolean[] flag = new boolean[nums.length];

        //从左向右找，找到最大值，然后再从最大值开始向右找次大值，直到最右边没有值，
        // 然后顺着右方向到第一个已近被标记过的数之间的数
        markMax(nums, flag, k, 0, nums.length - 1);

        for (int i = 0, j = 0; i < flag.length; i++) {
            if (flag[i]) {
                result[j++] = nums[i];
            }
        }
        return result;
    }

    private void markMax(int[] nums, boolean[] flag, int k, int start, int end) {
        if (k <= 0) {//如果还需要标记的数字为-1表示不需要再标记了
            return;
        }
        boolean isSuccess = true;
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]) {
                isSuccess = false;
                break;
            }
        }
        if (isSuccess) {//表示所有数字已近标记完成了，无法标记更多数字了
            return;
        }

        //1、寻找区间的最大值
        //2、如果该区间都已近被标记了，则需要向左找一个尚未被标记的区间，继续找最大值
        if (isAllMark(flag, start, end)) {//该区间中是否都已近被标记了，如果被标记了，则需要向左找一个区间
            int left = getLeftPart(flag, start);
            markMax(nums, flag, k, left, start - 1);
        } else {
            int maxIndex = -1;
            int tempMax = Integer.MIN_VALUE;
            for (int index = start; index <= end; index++) {
                if (!flag[index] && tempMax < nums[index]) {//没有被标记 && 是临时最大值
                    maxIndex = index;
                    tempMax = nums[index];
                }
            }
            k--;
            flag[maxIndex] = true;
            markMax(nums, flag, k, maxIndex, end);
        }
    }

    private int getLeftPart(boolean[] flag, int start) {
        int result = 0;
        boolean isStart = false;
        for (int i = start; i >= 0; i--) {
            if (!flag[i] && !isStart) {//表示第一次遇到没有被标记的数字
                isStart = true;
            }
            if (isStart && (i == 0 || flag[i])) {//可以设置左边开始位置了，条件：第一次遇到被标记了或者遇到0
                result = i;
                break;
            }
        }
        return result;
    }

    private boolean isAllMark(boolean[] flag, int start, int end) {
        boolean result = true;
        for (int i = start; i <= end; i++) {
            if (!flag[i]) {
                result = false;
                break;
            }
        }
        return result;
    }


    @Test
    public void t2() {
//        int[] nums1 = {2, 5, 6, 4, 4, 0};
//        int[] nums2 = {7, 3, 8, 0, 6, 5, 7, 6, 2};
        int[] nums1 = {1, 1};
        int[] nums2 = {1, 1, 9,};
        StringUtil.printObject(combination(nums1, nums2));
    }

    private int[] combination(int[] nums1, int[] nums2) {
        if (null == nums1 || 0 == nums1.length) {
            return nums2;
        }
        if (null == nums2 || 0 == nums2.length) {
            return nums1;
        }
        int[] result = new int[nums1.length + nums2.length];

        for (int n1 = 0, n2 = 0, index = 0; n1 < nums1.length || n2 < nums2.length; index++) {
            if (n1 < nums1.length && n2 < nums2.length) {
                if (nums1[n1] > nums2[n2]) {//第一个数大于第二个数
                    result[index] = nums1[n1];
                    n1++;
                    continue;
                }
                if (nums2[n2] > nums1[n1]) {//第二个数大于第一个数
                    result[index] = nums2[n2];
                    n2++;
                    continue;
                }
                if (nums1[n1] == nums2[n2]) {//如果两个数相等，就需要判断两个相等数字的各自后面的值是否相等，
                    for (int sameLength = 0; ; sameLength++) {
                        if (n1 + sameLength >= nums1.length && n2 + sameLength >= nums2.length) {//相等数字都是最后一位了，随便选一个就行了
                            result[index] = nums1[n1];
                            n1++;
                            break;
                        }
                        if (n1 + sameLength >= nums1.length && n2 + sameLength < nums2.length) {//从相等开始计算，nums1的长度比nums2的长度小
                            result[index] = nums2[n2];
                            n2++;
                            break;
                        }
                        if (n2 + sameLength >= nums2.length && n1 + sameLength < nums1.length) {//从相等开始计算，nums2的长度比nums1的长度小
                            result[index] = nums1[n1];
                            n1++;
                            break;
                        }
                        if (n1 + sameLength < nums1.length && n2 + sameLength < nums2.length && nums1[n1 + sameLength] == nums2[n2 + sameLength]) {//相等数字还不是最后一位时
                            continue;//需要继续对比后面的数字是否相等
                        }
                        if (nums1[n1 + sameLength] != nums2[n2 + sameLength]) {//遇到两个数字不一样时，需要比较大小
                            if (nums1[n1 + sameLength] > nums2[n2 + sameLength]) {
                                result[index] = nums1[n1];
                                n1++;
                                break;
                            } else {//不可能是两个数字相等，只能是n2的比n1大
                                result[index] = nums2[n2];
                                n2++;
                                break;
                            }
                        }
                    }
                    continue;
                }
            }
            if (n1 == nums1.length && n2 < nums2.length) {//nums1数组为空了
                result[index] = nums2[n2];
                n2++;
                continue;
            }
            if (n2 == nums2.length && n1 < nums1.length) {//nums2数组为空了
                result[index] = nums1[n1];
                n1++;
            }
        }

        return result;
    }

    /**
     * 最佳答案
     */
    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
