package com.currentbp.util.all;

import com.currentbp.common.entity.Course;
import com.currentbp.common.entity.Student;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author baopan
 * @createTime 20191112
 */
public class CglibCopyBeanTest {

    @Test
    public void BasicCopyBean(){
        Student student = new Student();
        CglibCopyBean.BasicCopyBean(new Student(1,"11"),student);
        StringUtil.printObject(student);
        Course course = new Course();
        CglibCopyBean.BasicCopyBean(new Student(2,"12222"),course);
        StringUtil.printObject(course);
    }

}