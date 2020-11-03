package com.currentbp.test.java8;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2020/10/14 15:38
 */
public class PredicateTest {

    @Test
    public void t1() {
        doSome(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7), x -> x % 2 == 0);
    }

    public void doSome(List<Integer> ids, Predicate<Integer> func) {
        List<Integer> remainIds = ids.stream().filter(func).collect(Collectors.toList());
        StringUtil.printObject(remainIds);
    }
}
