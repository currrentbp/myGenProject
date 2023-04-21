package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 20210801
 */
public class T1941AreOccurrencesEqual {
    /*
给你一个字符串s，如果 s是一个 好字符串，请你返回 true，否则请返回 false。
如果 s中出现过的所有 字符的出现次数 相同，那么我们称字符串 s是 好字符串。
示例 1：
输入：s = "abacbc"
输出：true
解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
示例 2：
输入：s = "aaabb"
输出：false
解释：s 中出现过的字符为 'a' 和 'b' 。
'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
     */

    @Test
    public void t1() {
        StringUtil.printObject(areOccurrencesEqual("abacbc"));
    }

    public boolean areOccurrencesEqual(String s) {
        if(null == s || s.length() == 1){
            return true;
        }
        Map<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        int count = result.get(s.charAt(0));
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            if(count != entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
