package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author baopan
 * @createTime 5/3/2023 8:32 PM
 */
public class T0648replaceWords {
    /*
在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。
如果继承词有许多可以形成它的词根，则用最短的词根替换它。
你需要输出替换之后的句子。
示例 1：
输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"
示例 2：
输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
输出："a a b c"

     */
    @Test
    public void t1(){
        StringUtil.printObject(replaceWords(Lists.newArrayList("cat","bat","rat"),"the cattle was rattled by the battery"));
        StringUtil.printObject(replaceWords(Lists.newArrayList("a","b","c"),"aadsfasf absbs bbab cadsfafs"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary.isEmpty()) {
            return sentence;
        }
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        String[] sources = sentence.split(" ");
        for (int i = 0; i < sources.length; i++) {
            for (int j = 0; j < dictionary.size(); j++) {
                if (sources[i].startsWith(dictionary.get(j))) {
                    sources[i] = dictionary.get(j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sources.length; i++) {
            sb.append(sources[i] + " ");
        }

        return sb.toString().trim();
    }
}
