package com.currentbp.test.spring;

import com.currentbp.common.model.Course;
import com.currentbp.common.model.Student;
import com.currentbp.common.model.Teacher;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20211018
 */
public class SpringTest {
    @Test
    public void copy(){
        List<Student> students = new ArrayList<>();
        Student student = new Student(1, "1");
        student.setCourse(new Course(1,"c1"));
        List<Course> myCourses = new ArrayList<>();
        myCourses.add(new Course(2,"c2"));
        myCourses.add(new Course(3,"c3"));
        student.setMyCourses(myCourses);
        students.add(student);

        List<Teacher> teachers = students.stream().map(x -> {
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(x, teacher);
            return teacher;
        }).collect(Collectors.toList());
        StringUtil.printObject(teachers);
    }

    @Test
    public void copy2(){
        List<Student> students = new ArrayList<>();
        Student student = new Student(1, "1");
        student.setCourse(new Course(1,"c1"));
        List<Course> myCourses = new ArrayList<>();
        myCourses.add(new Course(2,"c2"));
        myCourses.add(new Course(3,"c3"));
        student.setMyCourses(myCourses);
        students.add(student);

        List<Teacher> teachers = new ArrayList<>();
        BeanUtils.copyProperties(student,teachers);
        StringUtil.printObject(teachers);
    }

}
