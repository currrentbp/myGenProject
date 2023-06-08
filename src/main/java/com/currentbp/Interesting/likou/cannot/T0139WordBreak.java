package com.currentbp.Interesting.likou.cannot;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20220908
 */
public class T0139WordBreak {
    /*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    注意，你可以重复使用字典中的单词。
示例 3
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
提示：
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s 和 wordDict[i] 仅有小写英文字母组成
wordDict 中的所有字符串 互不相同
     */
    /*
解题思路：
dpi = dpj && check(j-i);
dpi:表示从0-i的字符串都符合
dpj:表示从0-j的字符串都符合
check(j-i):表示检查j到i的字符是否符合
     */
    @Test
    public void t1() {
        System.out.println(wordBreak("leetcode", Lists.newArrayList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Lists.newArrayList("apple", "pen")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wds = new HashSet<>(wordDict);

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                boolean dpj = dp[j];
                boolean contains = wds.contains(substring);
                if (dpj && contains) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
