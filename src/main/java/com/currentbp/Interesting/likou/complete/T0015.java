package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 20190114
 */
public class T0015 {
    /*
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
     */
    //https://leetcode-cn.com/problems/3sum/


    @Test
    public void t1() {
        System.out.println(threeSum(new int[]{1, -1, -1, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> originals = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (originals.containsKey(nums[i])) {
                originals.put(nums[i], originals.get(nums[i]) + 1);
            } else {
                originals.put(nums[i], 1);
            }
        }
        List<Integer> keys = new ArrayList<>(originals.keySet());
        Collections.sort(keys);
        Map<Integer, Integer> index = new HashMap<>(keys.size());
        for (int i = 0; i < keys.size(); i++) {
            index.put(keys.get(i), i);
        }
        for (int startA = 0; startA < keys.size(); startA++) {
            Integer a = keys.get(startA);
            if (originals.get(a) >= 2) { //a+a=b  or a+a=a
                int b = 2 * a * -1;
                Integer bCount = originals.get(b);
                if (null != bCount) {
                    if (b == a && bCount >= 3) {
                        result.add(get1(a, a, a));
                        continue;
                    }
                    if (a != b) {
                        result.add(get1(a, a, b));
                    }
                }
            }
            //a+b=c
            for (int startB = startA + 1; startB < keys.size(); startB++) {
                Integer b = keys.get(startB);
                int c = -1 * (a + b);
                Integer cindex = index.get(c);
                if (c != a && c != b && null != originals.get(c) && cindex > startB && cindex > startA) {
                    result.add(get1(a, b, c));
                }
            }
        }
        return result;
    }

    /*
    这个更慢，大概原因：string对比比较慢
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<String> strings = new ArrayList<>(nums.length);
        Map<Integer, Integer> originals = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (originals.containsKey(nums[i])) {
                originals.put(nums[i], originals.get(nums[i]) + 1);
            } else {
                originals.put(nums[i], 1);
            }
        }
        List<Integer> keys = new ArrayList<>(originals.keySet());
        for (int startA = 0; startA < keys.size(); startA++) {
            Integer a = keys.get(startA);
            if (originals.get(a) >= 2) { //a+a=b  or a+a=a
                int b = 2 * a * -1;
                Integer bCount = originals.get(b);
                if (null != bCount) {
                    if (b == a && bCount >= 3) {
                        String temp = "" + a + a + a;
                        if (!strings.contains(temp)) {
                            strings.add(temp);
                            result.add(get1(a, a, a));
                        }
                        continue;
                    }
                    if (a != b) {
                        String t1 = a > b ? "" + b + a + a : "" + a + a + b;
                        if (!strings.contains(t1)) {
                            strings.add(t1);
                            result.add(get1(a, a, b));
                        }

                    }
                }
            }
            //a+b=c
            for (int startB = startA + 1; startB < keys.size(); startB++) {
                Integer b = keys.get(startB);
                int c = -1 * (a + b);
                if (c != a && c != b && null != originals.get(c)) {
                    String sortStr = getSortStr(a, b, c);
                    if (!strings.contains(sortStr)) {
                        strings.add(sortStr);
                        result.add(get1(a, b, c));
                    }
                }
            }
        }
        return result;
    }

    private String getSortStr(int a, int b, int c) {
        String result = "";
        if (a < Math.min(b, c)) {
            result = result + a + Math.min(b, c) + Math.max(b, c);
        } else if (b < Math.min(a, c)) {
            result = result + b + Math.min(a, c) + Math.max(a, c);
        } else {
            result = result + c + Math.min(a, b) + Math.max(a, b);
        }
        return result;
    }

    private List<Integer> get1(int a, int b, int c) {
        List<Integer> result = new ArrayList<>(3);
        result.add(a);
        result.add(b);
        result.add(c);
        return result;
    }

    /*
        官网最佳答案
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;

    }
}
