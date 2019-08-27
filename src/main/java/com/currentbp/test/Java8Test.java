package com.currentbp.test;

import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author baopan
 * @createTime 20190823
 */
public class Java8Test {
    @Test
    public void t1(){
        String[] words = new String[]{"Hello","World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split("l"))
                .distinct()
                .collect(toList());
        for (String[] strings : a) {
            ListUtil.printList(strings);
        }
    }
}
