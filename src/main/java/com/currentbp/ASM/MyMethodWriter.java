package com.currentbp.ASM;

import com.currentbp.common.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 */
public class MyMethodWriter {

    @Test
    public void t1(){
        Student student = new Student();
        student.setId(1);
        student.setName("baopan");
        List<Student> students = Arrays.asList(student);
        System.out.println(students.toString());
    }

}
