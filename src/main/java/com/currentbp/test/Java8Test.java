package com.currentbp.test;

import com.currentbp.common.entity.Student;
import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author baopan
 * @createTime 20190823
 */
public class Java8Test {

    @Test
    public void sort(){
        List<Student> students = new ArrayList<>(2);
        Student student1 = new Student(2,"ss");
        Student student2 = new Student(3,"ff");
        students.add(student1);
        students.add(student2);

        List<Student> collect = students.stream().sorted((x, y) -> {
            return 3 == x.getId() ? -1 : 1;
        }).collect(toList());
        ListUtil.printList(collect);
    }
    @Test
    public void t2(){
        List<Student> students = new ArrayList<>(2);
        Student student1 = new Student(2,"ss");
        Student student2 = new Student(3,"ff");
        students.add(student1);
        students.add(student2);
        int sum = students.stream().mapToInt(Student::getId).sum();
        System.out.println(sum);
    }

    @Test
    public void t1(){
        String[] words = new String[]{"Hello","World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split("l"))
                .distinct()
                .collect(toList());
        for (String[] strings : a) {
            ListUtil.printList(strings);
        }
    }
}
