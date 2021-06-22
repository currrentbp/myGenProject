package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20210622
 */
public class T038Permutation {

    /*
    输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
限制
1 <= s 的长度 <= 8
     */

    @Test
    public void t1() {
        String[] abcs = permutation("abc");
        StringUtil.printObject(abcs);
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> result = new HashSet<>();
        boolean[] visited = new boolean[chars.length];
        doEach(chars, result, visited, "");
        return result.toArray(new String[0]);
    }

    private void doEach(char[] chars, Set<String> result, boolean[] visited, String s) {
        if (s.length() == chars.length) {
            result.add(s);
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            doEach(chars, result, visited, s + chars[i]);
            visited[i] = false;
        }
    }
}
