package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2020/9/27 17:10
 */
public class MapTest {

    @Test
    public void t1(){
        Integer integer = Optional.of(new Student(null, "1")).map(Student::getId).orElse(10);
        System.out.println(integer);

        List<Student> students = Lists.newArrayList(new Student(1,"1"),new Student(2,"2"));
        List<Integer> collect = students.stream().map(Student::getId).collect(Collectors.toList());
        StringUtil.printObject(collect);
    }
}
