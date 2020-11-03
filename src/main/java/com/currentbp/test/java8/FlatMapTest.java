package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2020/10/27 11:30
 */
public class FlatMapTest {
    @Test
    public void t1() {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = Lists.newArrayList(1, 2, 3);
        List<Integer> l2 = Lists.newArrayList(4, 5, 6);
        l.add(l1);
        l.add(l2);

        List<Student> students = l.stream().flatMap(list -> list.stream().map(x -> new Student(x, "" + x))).collect(Collectors.toList());
        StringUtil.printObject(students);
    }

    @Test
    public void t2() {
        List<Integer> ageRanges = Lists.newArrayList(1, 2, 3);
        List<String> provinces = Lists.newArrayList("4", "5", "6");
        List<Student> students = provinces.stream().flatMap(p -> ageRanges.stream().map(a -> new Student(a, p))).collect(Collectors.toList());
        StringUtil.printObject(students);
    }
}
