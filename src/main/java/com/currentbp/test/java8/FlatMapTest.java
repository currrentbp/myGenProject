package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
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

    @Test
    public void t3(){
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student(1,"1"));
        students1.add(new Student(2,"2"));
        students1.add(new Student(3,"3"));

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student(4,"4"));
        students2.add(new Student(5,"5"));
        students2.add(new Student(6,"6"));

        List<Student> students3 = new ArrayList<>();
        students3.add(new Student(7,"7"));
        students3.add(new Student(8,"8"));
        students3.add(new Student(9,"9"));

        List<List<Student>> lists = new ArrayList<>();
        lists.add(students1);
        lists.add(students2);
        lists.add(students3);
        StringUtil.printObject(lists);
        List<Student> collect = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        StringUtil.printObject(collect);
    }
}
