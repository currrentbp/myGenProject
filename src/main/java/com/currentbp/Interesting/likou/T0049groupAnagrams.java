package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2020/11/20 19:59
 */
public class T0049groupAnagrams {
    /*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：
所有输入均为小写字母。
不考虑答案输出的顺序。
解决思路：
1、拆解字符串成为map
2、根据map中数量和字符对应的数量对比，判断是否同一个map
3、结构：Map<String,Map<Char,Integer>>
     */

    @Test
    public void t1() {
        StringUtil.printObject(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character,Integer>,Integer> map2IndexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {

        }

        return result;
    }

    private Map<Character, Integer> getMapByWord(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                result.put(c, result.get(c) + 1);
            }
        }
        return result;
    }
}
