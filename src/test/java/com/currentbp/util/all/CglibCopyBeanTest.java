package com.currentbp.util.all;

import com.currentbp.common.model.Course;
import com.currentbp.common.model.Student;
import org.junit.Test;

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