package com.currentbp.nlp.compare;

import com.currentbp.nlp.Simhash;
import com.currentbp.test.java8.TripleTest;
import com.currentbp.util.all.MathUtil;
import com.currentbp.util.all.StreamUtil;
import com.currentbp.util.all.StringUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
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
    public void t2() {
        Simhash simhash = new Simhash(4, 3);
        Long aLong = simhash.calSimhash("中国人 外国人 友人");
        Long aLong1 = simhash.calSimhash("外国人 中国人 友人");

        System.out.println("===>" + hamming(aLong, aLong1));

        System.out.println(MathUtil.getBinary4Num(aLong));
        System.out.println(MathUtil.getBinary4Num(aLong1));
    }

    public boolean isSameBook(String book1, String book2) {
        List<String> book1List = StreamUtil.getListByAbstrackPath("C:\\Users\\baopan\\Desktop\\nlp\\book4.txt");
        List<String> book2List = StreamUtil.getListByAbstrackPath("C:\\Users\\baopan\\Desktop\\nlp\\book5.txt");
        List<String> book1s = book1List.stream().filter(x -> x.length() >= 30).filter(x -> StringUtil.computeWordCount(x) >= 15).collect(Collectors.toList());
        List<String> book2s = book2List.stream().filter(x -> x.length() >= 30).filter(x -> StringUtil.computeWordCount(x) >= 15).collect(Collectors.toList());

        Map<Long, String> b1Set = getSimHash(book1s);
        Map<Long, String> b2Set = getSimHash(book2s);
//
//        //1、第一种策略，一行都相等才算重复
//        Set<Long> remain = new HashSet<>(b1Set.keySet());
//        remain.retainAll(b2Set.keySet());
//        int size = remain.size();
//        System.out.println("size:" + size);
//
//        for (Long aLong : remain) {
//            System.out.println("hashLong:"+aLong);
//            System.out.println("firstContent:"+b1Set.get(aLong));
//            System.out.println("secondContent:"+b2Set.get(aLong));
//        }

        //2、第二种策略，只要相似度够就算重复
        List<Long> b1List = new ArrayList<>(b1Set.keySet());
        List<Long> b2List = new ArrayList<>(b2Set.keySet());
        List<Triple<Long, Long, Integer>> remainList = new ArrayList<>();
        for (int i = 0; i < b1List.size(); i++) {
            for (int j = 0; j < b2List.size(); j++) {
                int hamming = hamming(b1List.get(i), b2List.get(j));
                if (hamming >= 31) {
                    remainList.add(Triple.of(b1List.get(i), b2List.get(j), hamming));
                }
            }
        }
        for (Triple<Long, Long, Integer> aLong : remainList) {
            System.out.println("hashLong:" + aLong.getLeft() + " " + aLong.getMiddle() + " " + aLong.getRight());
            System.out.println("firstContent:" + b1Set.get(aLong.getLeft()));
            System.out.println("secondContent:" + b2Set.get(aLong.getMiddle()));
        }
        System.out.println(remainList.size());


        return true;
    }

    public Map<Long, String> getSimHash(List<String> list) {
        Simhash simhash = new Simhash(4, 3);
        Map<Long, String> set = new HashMap<>();
        list.forEach(item -> {
            Long simhashVal = simhash.calSimhash(item);
            set.put(simhashVal, item);

//            System.out.println(simhash.isDuplicate(simhashVal));//todo not work
//            simhash.store(simhashVal, item);
        });
        return set;
    }

    private int bitNum = 64;

    // 计算汉明距离
    private int hamming(Long s1, Long s2) {
        int dis = 0;
        for (int i = 0; i < bitNum; i++) {
            long l1 = s1 >> i & 1;
            long l2 = s2 >> i & 1;
            if ((l1) != (l2)) {
                dis++;
            }
        }
        return dis;
    }
}
