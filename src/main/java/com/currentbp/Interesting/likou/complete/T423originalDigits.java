package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 5/3/2023 10:32 PM
 */
public class T423originalDigits {
    /*
给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
示例 1：
输入：s = "owoztneoer"
输出："012"
示例 2：
输入：s = "fviefuro"
输出："45"

zero one two three four five six seven、eight、nine

o n e t w r f u i v s x g h z

特殊：z   x  g  w  u

余：one three five seven nine

one  five seven
余下：three nine
     */

    Triple<Character, String, Integer> zero = new Triple('z', "zero", 0);
    Triple<Character, String, Integer> two = new Triple('w', "two", 2);
    Triple<Character, String, Integer> four = new Triple('u', "four", 4);
    Triple<Character, String, Integer> six = new Triple('x', "six", 6);
    Triple<Character, String, Integer> eight = new Triple('g', "eight", 8);

    Triple<Character, String, Integer> one = new Triple('o', "one", 1);
    Triple<Character, String, Integer> five = new Triple('f', "five", 5);
    Triple<Character, String, Integer> seven = new Triple('s', "seven", 7);
    Triple<Character, String, Integer> three = new Triple('r', "three", 3);

    Triple<Character, String, Integer> nine = new Triple('i', "nine", 9);

    @Test
    public void t1() {
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
        System.out.println(originalDigits("zerozero"));
    }

    public String originalDigits(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> char2NumMap = getNum(s);

        Map<Integer, Integer> numMap = new HashMap<>();
        //第一批
        Set<Triple<Character, String, Integer>> specialNums = new HashSet<>();
        specialNums.add(zero);
        specialNums.add(two);
        specialNums.add(four);
        specialNums.add(six);
        specialNums.add(eight);
        doSpecialNum(char2NumMap, specialNums, numMap);
        specialNums = new HashSet<>();
        specialNums.add(one);
        specialNums.add(five);
        specialNums.add(seven);
        specialNums.add(three);
        doSpecialNum(char2NumMap, specialNums, numMap);
        specialNums = new HashSet<>();
        specialNums.add(nine);
        doSpecialNum(char2NumMap, specialNums, numMap);

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i <= 9; i++) {
            Integer num = numMap.getOrDefault(i, 0);
            for (int j = 0; j < num; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    private void doSpecialNum(Map<Character, Integer> char2NumMap,
                              Set<Triple<Character, String, Integer>> specialNums, Map<Integer, Integer> numMap) {


        for (Triple<Character, String, Integer> specialNumPair : specialNums) {
            Integer keyNum = char2NumMap.getOrDefault(specialNumPair.getLeft(), 0);
            if (keyNum == 0) {
                continue;
            }
            String value = specialNumPair.getMiddle();
            for (char charItem : value.toCharArray()) {
                Integer num = char2NumMap.get(charItem);
                char2NumMap.put(charItem, num - keyNum);
            }
            numMap.put(specialNumPair.getRight(), numMap.getOrDefault(specialNumPair.getRight(), 0) + keyNum);
        }
    }

    private Map<Character, Integer> getNum(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer num = result.getOrDefault(c, 0);
            result.put(c, num + 1);
        }
        return result;
    }

    class Triple<L, M, R> {
        public L left;
        public M middle;
        public R right;

        public Triple() {
        }

        public Triple(L left, M middle, R right) {
            this.left = left;
            this.right = right;
            this.middle = middle;
        }

        public L getLeft() {
            return left;
        }

        public M getMiddle() {
            return middle;
        }

        public R getRight() {
            return right;
        }


    }
}
