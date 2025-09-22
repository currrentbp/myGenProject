package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2024/6/14 23:06
 */
public class T0179largestNumber {
    /*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
示例 1：
输入：nums = [10,2]
输出："210"
示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"
     */

    @Test
    public void t1() {
        System.out.println(largestNumber(new int[]{0, 0}));
//        System.out.println(largestNumber(new int[]{34323, 3432}));
//        System.out.println(largestNumber(new int[]{432,43243}));
//        System.out.println(largestNumber(new int[]{10, 2}));
//        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String largestNumber(int[] nums) {
        List<List<Integer>> sortNums = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            sortNums.add(new ArrayList<>());
        }
        //初始化
        for (int i = 0; i < nums.length; i++) {
            String temp = "" + nums[i];
            char ch = temp.charAt(0);
            int index = ch - '0';
            List<Integer> list = sortNums.get(index);
            list.add(nums[i]);
        }
        //排序
        for (int i = 0, sortNumsSize = sortNums.size(); i < sortNumsSize; i++) {
            List<Integer> newSortNum = sortList(sortNums.get(i));
            sortNums.set(i, newSortNum);
        }
        //组装成字符串
        String result = appendString(sortNums);

        return result;
    }

    private String appendString(List<List<Integer>> sortNums) {
        String result = "";
        for (int i = sortNums.size() - 1; i >= 0; i--) {
            List<Integer> list = sortNums.get(i);
            for (int j = 0; j < list.size(); j++) {
                result = result + list.get(j);
            }
        }
        boolean hasOther = false;
        for (int i=0;i<result.length();i++){
            if(result.charAt(i) != '0'){
                hasOther = true;
                break;
            }
        }
        if(!hasOther){
            return "0";
        }
        return result;
    }

    private List<Integer> sortList(List<Integer> sortNum) {
        if (sortNum == null || sortNum.size() == 0) {
            return new ArrayList<>();
        }

        List<String> temps = new ArrayList<>();
        for (Integer integer : sortNum) {
            temps.add("" + integer);
        }
        sortList(temps, 0, temps.size() - 1);
        List<Integer> result = temps.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        return result;
    }

    private void sortList(List<String> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        sortList(list, left, middle);
        sortList(list, middle + 1, right);

        merge(list, left, middle, middle + 1, right);
    }

    private void merge(List<String> list, int leftOne, int leftTwo, int rightOne, int rightTwo) {
        if (leftOne > leftTwo || rightOne > rightTwo) {
            return;
        }
        int leftIndex = leftOne;
        int rightIndex = rightOne;
        List<String> newList = new ArrayList<>();
        while (leftIndex <= leftTwo || rightIndex <= rightTwo) {
            if (leftIndex > leftTwo) {//左边区间结束
                newList.add(list.get(rightIndex++));
                continue;
            }
            if (rightIndex > rightTwo) {//右边区间结束
                newList.add(list.get(leftIndex++));
                continue;
            }
            if (leftGreatRight(list.get(leftIndex), list.get(rightIndex))) {//左边大于右边，则把左边的添加到新列表中
                newList.add(list.get(leftIndex++));
                continue;
            } else {
                newList.add(list.get(rightIndex++));
                continue;
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            list.set(leftOne + i, newList.get(i));
        }
    }

    private boolean leftGreatRight(String left, String right) {
        if(left.equals("0") && right.equals("0")){
            return false;
        }
        String one = left + right;
        String two = right + left;
        for(int i=0;i<one.length();i++){
            if(one.charAt(i)>two.charAt(i)){
                return true;
            }
            if(two.charAt(i)>one.charAt(i)){
                return false;
            }
        }
        return false;
//
//        int leftLength = left.length();
//        int rightLength = right.length();
//        if (leftLength < rightLength) {
//            String leftFirst = "" + left.charAt(leftLength - 1);
//            for (int i = 0; i < rightLength - leftLength; i++) {
//                left = left + leftFirst;
//            }
//        }
//        if (leftLength > rightLength) {
//            String rightFirst = "" + right.charAt(rightLength - 1);
//            for (int i = 0; i < leftLength - rightLength; i++) {
//                right = right + rightFirst;
//            }
//        }
//        System.out.println("left:" + left + " right:" + right);
//        return Integer.parseInt(left) > Integer.parseInt(right);
    }
}
