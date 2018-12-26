package com.currentbp.Interesting.likou;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20181226
 */
public class T00003 {
    /*
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (null == s || 0 == s.length()) {
            return result;
        }
        String target = "";
        for (int i = 0; i < s.length(); i++) {
            int currLength = 1;
            for (; currLength < s.length() && i + currLength < s.length(); currLength++) {
                String temp = s.substring(i, i + currLength);
                //截取的位置超过了字符串的长度而且原先的长度比现在的长度要小
                if (i + currLength + 1 >= s.length()) {
                    if (result <= currLength) {
                        result = currLength;
                        target = temp;
                    }
                    break;
                }
                String next = s.substring(i + currLength, i + currLength + 1);
                boolean isNotContain = !temp.contains(next);
                //如果不包含该字符串而且原先的长度比现在的长度要小
                if (isNotContain) {
                    if (result <= currLength) {
                        result = currLength + 1;
                        target = s.substring(i, i + currLength + 1);
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(target);
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int result = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentLength = 1;
            Set<Integer> set = new HashSet<>(s.length());
            char init = s.charAt(i);
            set.add((int)init);
            int index = i;
            for (int j = i + 1; j < s.length(); j++) {
                char next = s.charAt(j);
                //不存在，则插入该字符
                if (!set.contains((int) next)) {
                    set.add((int) next);
                    currentLength++;
                    index = j;
                } else {//存在，则跳出循环
                    break;
                }
            }
            if (result <= currentLength) {
                start = i;
                end = index;
                result = currentLength;
            }
        }
        System.out.println("result: " + s.substring(start, end));
        return result;
    }

    @Test
    public void t1() {
        int i1 = lengthOfLongestSubstring2("bbbb");
        Assert.isTrue(i1==1,"error");
        int i2 = lengthOfLongestSubstring2("abcabcbb");
        Assert.isTrue(i2==3,"error");
        int i3 = lengthOfLongestSubstring2("pwwkew");
        Assert.isTrue(i3==3,"error");
        int i4 = lengthOfLongestSubstring2(" ");
        Assert.isTrue(i4==1,"error");
        int i5 = lengthOfLongestSubstring2("a");
        Assert.isTrue(i5==1,"error");
        int i6 = lengthOfLongestSubstring2("au");
        Assert.isTrue(i6==2,"error");
    }
}
