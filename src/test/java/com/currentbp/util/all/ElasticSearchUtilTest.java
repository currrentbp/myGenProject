package com.currentbp.util.all;

import com.alibaba.fastjson2.JSON;
import com.currentbp.common.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20210428
 */
public class ElasticSearchUtilTest {

    @Test
    public void testInsert() {
        new ElasticSearchSevenUtil().insert(new Student(8, "baopan"));
    }

    @Test
    public void testQueryByID() {
        Student student = new ElasticSearchSevenUtil().queryById("*", "", Student.class);
        System.out.println("===>student:" + JSON.toJSONString(student));
    }

    @Test
    public void queryByCondition(){
        List<String> student = new ElasticSearchSevenUtil().queryByCondition("mig2_appstore_aphrodite_log*",  String.class);
        System.out.println("===>student:"+JSON.toJSONString(student));
    }

    @Test
    public void t1() {
        Student student = new Student(1, "1111");
        String s = JSON.toJSONString(student);
        Student student1 = JSON.parseObject(s, Student.class);
        System.out.println(student1);
    }


    @Test
    public void t2(){
        Student student = new Student(11,"1");
        Student student2 = new Student(2,"2");
        Student student3 = new Student(3,"3");
        Student student4 = new Student(4,"4");
        Student student5 = new Student(5,"5");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        List<Student> collect = students.stream().sorted(Comparator.comparing(Student::getId, (x, y) -> {
            return y.compareTo(x);
        })).collect(Collectors.toList());
        System.out.println(collect);

    }


}