package com.currentbp.nlp.compare;

import com.currentbp.nlp.Simhash;
import com.currentbp.test.java8.TripleTest;
import com.currentbp.util.all.StreamUtil;
import com.currentbp.util.all.StringUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20220916
 */
public class CompareTwoBook {
    /*
对比两个文件的是否有可能有相同文案
     */

    @Test
    public void t1() {
        System.out.println(isSameBook("", ""));
    }

    @Test
    public void computeWordCount() {
        System.out.println(StringUtil.computeWordCount("baopan baoyou haha"));
        System.out.println(StringUtil.computeWordCount("My eyes saw black hair with dark red eyes holding a sinister"));
        System.out.println(StringUtil.computeWordCount("익숙한 목소리에 마리는 안도의 한숨을"));
        System.out.println(StringUtil.computeWordCount("Estoy muy ocupada atacando mis mechones castaños con una plancha de cabello"));
        System.out.println(StringUtil.computeWordCount(""));

    }

    public boolean isSameBook(String book1, String book2) {
        List<String> book1List = StreamUtil.getListByAbstrackPath("C:\\Users\\baopan\\Desktop\\nlp\\book4.txt");
        List<String> book2List = StreamUtil.getListByAbstrackPath("C:\\Users\\baopan\\Desktop\\nlp\\book5.txt");
        List<String> book1s = book1List.stream().filter(x -> x.length() >= 30).filter(x -> StringUtil.computeWordCount(x) >= 15).collect(Collectors.toList());
        List<String> book2s = book2List.stream().filter(x -> x.length() >= 30).filter(x -> StringUtil.computeWordCount(x) >= 15).collect(Collectors.toList());

        Map<Long, String> b1Set = getSimHash(book1s);
        Map<Long, String> b2Set = getSimHash(book2s);

        //1、第一种策略，一行都相等才算重复
        Set<Long> remain = new HashSet<>(b1Set.keySet());
        remain.retainAll(b2Set.keySet());
        int size = remain.size();
        System.out.println("size:" + size);

        for (Long aLong : remain) {
            System.out.println("hashLong:"+aLong);
            System.out.println("firstContent:"+b1Set.get(aLong));
            System.out.println("secondContent:"+b2Set.get(aLong));
        }

        //2、第二种策略，只要相似度够就算重复



        return size > 5;
    }

    public Map<Long, String> getSimHash(List<String> list) {
        Simhash simhash = new Simhash(4, 3);
        Map<Long, String> set = new HashMap<>();
        list.forEach(item -> {
            Long simhashVal = simhash.calSimhash(item);
            set.put(simhashVal, item);

            System.out.println(simhash.isDuplicate(simhashVal));//todo not work
            simhash.store(simhashVal, item);
        });
        return set;
    }
}
