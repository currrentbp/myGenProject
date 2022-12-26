package com.currentbp.Interesting.likou.offer.complete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 20221223
 */
public class T050firstUniqChar {
/*
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例 1:
输入：s = "abaccdeff"
输出：'b'
示例 2:
输入：s = ""
输出：' '
 */

    public char firstUniqChar(String s) {
        List<Character> allCharacters = new ArrayList<>();
        Map<Character, Integer> char2CountMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer count = char2CountMap.getOrDefault(c, 0);
            if (count <= 0) {
                char2CountMap.put(c, 1);
                allCharacters.add(c);
            } else {
                char2CountMap.put(c, count + 1);
            }
        }

        for (Character c : allCharacters) {
            if (char2CountMap.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }
}
