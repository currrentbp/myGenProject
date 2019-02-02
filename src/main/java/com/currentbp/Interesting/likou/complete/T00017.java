package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20190202
 */
public class T00017 {
    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     */

    @Test
    public void t1() {
        ListUtil.printList(letterCombinations("23"));
    }


    public List<String> letterCombinations(String digits) {
        String[] source = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String[] s1 = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            s1[i] = source[Integer.parseInt(digits.substring(i, i + 1)) - 1];
        }

        List<String> resultNew = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            int resultNewSize = resultNew.size();
            for (int j = 0; j < s1[i].length(); j++) {
                if (0 == resultNewSize) {
                    resultNew.add(s1[i].substring(j, j + 1));
                } else {
                    for (int k = 0; k < resultNewSize; k++) {
                        resultNew.add(resultNew.get(k) + s1[i].substring(j, j + 1));
                    }
                }
            }
            //remove
            for (int j = 0; j < resultNewSize; j++) {
                resultNew.remove(0);
            }
        }
        return resultNew;
    }


}
