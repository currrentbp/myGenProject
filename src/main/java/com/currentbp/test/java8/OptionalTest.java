package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void t1(){
        Optional<List> studentsOpt = Optional.of(Lists.newArrayList(new Student(1,"1"),new Student(2,"2")));
        studentsOpt.ifPresent(System.out::println);
        Optional<Student> student = Optional.ofNullable(new Student(3, "3"));
        student.ifPresent(System.out::println);
    }

    @Test
    public void t2(){
        Student student1 = new Student(1, "1");
        student1= null;
        Student student = Optional.ofNullable(student1).orElse(new Student(2, "2"));
        System.out.println(student);
    }



}