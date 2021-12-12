package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void t4(){
        Student student = new Student(1, "1");

        String format = String.format("%.2f", 1234567 / 100d);
        System.out.println(format);

        long l = Math.addExact(99998L, 1L);
        long maxAmount = 1_0000L;
        System.out.println(l<=maxAmount);
    }

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


    @Test
    public void t3(){
        if(1!=1){

        }else if(2==2){
            System.out.println("========");
        }else if(3==3){
            System.out.println("+++++++");
        }
    }

}
