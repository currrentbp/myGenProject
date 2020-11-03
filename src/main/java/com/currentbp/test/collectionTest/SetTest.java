package com.currentbp.test.collectionTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2020/10/27 15:48
 */
public class SetTest {

    @Test
    public void setNull2Set(){
        Set<Integer> set = new HashSet<>();
        set.add(null);
        StringUtil.printObject(set);
    }

    @Test
    public void testEmpty(){
        Set<String> result = new HashSet<>();
        Set<Long> collect = result.stream().map(Long::parseLong).collect(Collectors.toSet());
        StringUtil.printObject(collect);
    }
}
