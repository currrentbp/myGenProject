package com.currentbp.test.java8;

import com.currentbp.common.model.Persion;
import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void time(){
        System.out.println(518400/(60*60*24));
    }

    @Test
    public void sort(){
        List<Long>result1 = new ArrayList<>();
        result1.add(1L);
        result1.add(2L);
        List<Long> result = result1.stream().sorted(Comparator.comparingLong(x-> -x)).collect(Collectors.toList());
        StringUtil.printObject(result);
    }

    @Test
    public void t1() {
        List<Student> students = Lists.newArrayList(new Student(1, "1"), new Student(2, "2"));
        List<Persion> collect = students.stream().map(s -> new Persion(s.getId(), s.getName())).collect(Collectors.toList());
        StringUtil.printObject(collect);
        List<Persion> persions = students.stream().map(s -> {
            return new Persion(s.getId(), s.getName());
        }).collect(Collectors.toList());

    }

    @Test
    public void t2() {
        List<Student> students = Lists.newArrayList(new Student(1, "1"), new Student(2, "2"));
        List<Integer> collect = students
                .stream()
                .map(Student::getId)
                .collect(
                        Collectors.toList()
                );
        StringUtil.printObject(collect);
    }

}
