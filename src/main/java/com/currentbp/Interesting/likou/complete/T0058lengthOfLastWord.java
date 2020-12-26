package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20201219
 */
public class T0058lengthOfLastWord {
    /*
给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。
如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
如果不存在最后一个单词，请返回 0。
说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
示例:
输入: "Hello World"
输出: 5
     */
    @Test
    public void t1() {
        StringUtil.printObject(lengthOfLastWord("hello world"));
    }

    public int lengthOfLastWord(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        int current = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                current = 0;
                continue;
            }
            current++;
        }
        return current;
    }
}
