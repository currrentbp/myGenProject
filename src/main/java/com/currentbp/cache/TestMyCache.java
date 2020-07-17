package com.currentbp.cache;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/7/17 12:13
 */
public class TestMyCache {

    private LocalCache<Integer, List<Student>> localCacheBuilder3= LocalCacheBuilder.newBuilder().setMaxTime(211111L).build(new LocalCache<Integer, List<Student>>() {
        @Override
        List<Student> loading(Integer integer) {
            Student student = new Student(integer, "name" + integer);
            Student student2 = new Student(integer, "name" + integer);
            List<Student> students = new ArrayList<>();
            students.add(student);
            students.add(student2);
            return students;
        }
    });
    @Test
    public void t3(){
        for (int i = 0; i < 3; i++) {
            List<Student> student = localCacheBuilder3.get(i);
            StringUtil.printObject(student);
        }

        System.out.println("==============");
        new Thread(() -> {
            List<Student> student = localCacheBuilder3.get(15);
            StringUtil.printObject(student);
        }).start();

        for (int i = 0; i < 3; i++) {
            List<Student> student = localCacheBuilder3.get(i);
            StringUtil.printObject(student);
        }

        try {
            Thread.sleep(1111111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private LocalCache<Integer, Student> studentLocalCache = new LocalCache<Integer, Student>() {
        @Override
        Student loading(Integer integer) {
            Student student = new Student(integer, "name" + integer);
            return student;
        }
    };

    private LocalCache<Integer, Student> localCacheBuilder = LocalCacheBuilder.newBuilder().setMaxTime(2L).build(new LocalCache<Integer, Student>() {
        @Override
        Student loading(Integer integer) {
            Student student = new Student(integer, "name" + integer);
            return student;
        }
    });

    @Test
    public void t1() {

        for (int i = 0; i < 3; i++) {
            Student student = localCacheBuilder.get(i);
            StringUtil.printObject(student);
        }

        System.out.println("==============");
        new Thread(() -> {
            Student student = localCacheBuilder.get(15);
            StringUtil.printObject(student);
        }).start();

        for (int i = 0; i < 3; i++) {
            Student student = localCacheBuilder.get(i);
            StringUtil.printObject(student);
        }
        Student student = localCacheBuilder.get(15);
        StringUtil.printObject(student);


        try {
            Thread.sleep(1111111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void t2() {

        for (int i = 0; i < 3; i++) {
            Student student = studentLocalCache.get(i);
            StringUtil.printObject(student);
        }

        System.out.println("==============");
        new Thread(() -> {
            Student student = studentLocalCache.get(15);
            StringUtil.printObject(student);
        }).start();

        for (int i = 0; i < 3; i++) {
            Student student = studentLocalCache.get(i);
            StringUtil.printObject(student);
        }
        Student student = studentLocalCache.get(15);
        StringUtil.printObject(student);


        try {
            Thread.sleep(1111111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
