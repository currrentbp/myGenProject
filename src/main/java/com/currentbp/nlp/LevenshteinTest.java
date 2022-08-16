package com.currentbp.nlp;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220815
 */
public class LevenshteinTest {
    /*
莱文斯坦距离，又称Levenshtein距离，是编辑距离（edit distance）的一种。指两个字串之间，
由一个转成另一个所需的最少编辑操作次数。
许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
     */

    @Test
    public void t1(){
        String s1 = "1baopan1";
        String s2 = "baoyou22";
        int levenshteinDistance = StringUtils.getLevenshteinDistance(s1, s2);
        System.out.println(levenshteinDistance);
    }
}
