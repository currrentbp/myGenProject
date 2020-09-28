package com.currentbp.test.commonsApacheOrgTest;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2020/9/28 11:11
 */
public class PairTest {

    @Test
    public void t1(){
        List<Student> students = Lists.newArrayList(new Student(1,"1"),new Student(2,"2"));
        List<Integer> collect = students.stream().map(s -> Pair.of(s.getId(), s.getName()))
                .map(s -> s.getLeft()).collect(Collectors.toList());
        StringUtil.printObject(collect);

        List<String> collect1 = students.stream().map(s -> Pair.of(s.getId(), s.getName()))
                .map(Pair::getRight).collect(Collectors.toList());
        StringUtil.printObject(collect1);
    }

}
