package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
3、结构：Map<String,Map<Map<Char,Integer>,Integer>>:Map<排序好的缩减字符串，Map<Map<char:单个字符,Integer:数量>,Integer:在外层列表的位置>

解决方案2：
1、结构：Map<String,Integer>:Map<String:字符+count，Integer：数组的位置>
2、字符+count：字符按顺序排序

解题思路3：
1、结构：Map<String:字符+count，List<String:字符串>>
     */

    @Test
    public void t1() {
        StringUtil.printObject(groupAnagrams3(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> simpleStr2IndexMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String simpleStr = getSimpleStr(getMapByWord(strs[i]));
            List<String> current = simpleStr2IndexMap.getOrDefault(simpleStr, new ArrayList<>());
            if(0 == current.size()){
                current.add(strs[i]);
                simpleStr2IndexMap.put(simpleStr,current);
            }else{
                current.add(strs[i]);
            }
        }

        return new ArrayList<>(simpleStr2IndexMap.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> simpleStr2IndexMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String simpleStr = getSimpleStr(getMapByWord(strs[i]));
            if (simpleStr2IndexMap.containsKey(simpleStr)) {
                List<String> strings = result.get(simpleStr2IndexMap.get(simpleStr));
                strings.add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                result.add(temp);
                simpleStr2IndexMap.put(simpleStr, result.size() - 1);
            }
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

    /**
     * 结构: a1b2c3d4
     */
    private String getSimpleStr(Map<Character, Integer> map) {
        StringBuffer result = new StringBuffer();
        map.keySet().stream().sorted().forEach(x -> {
            result.append(x.charValue()).append(map.get(x));
        });
        return result.toString();
    }

    /**
     * 官网最佳答案
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] hash = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        List<List<String>> lists = new ArrayList<>();

        Map<Long, List<String>> map = new HashMap<>();

        for (String str : strs) {

            long count = 1;
            for (int i = 0; i < str.length(); i++) {
                count *= hash[str.charAt(i) - 'a'];
            }

            if (map.containsKey(count)) {
                map.get(count).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(count, newList);
            }

        }

        return new ArrayList<>(map.values());
    }
}
