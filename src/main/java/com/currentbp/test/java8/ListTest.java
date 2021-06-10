package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.RandomUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("1");
        System.out.println(list);
        int abs = java.lang.Math.abs(1);
    }

    @Test
    public void nullAdd(){
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.addAll(list1);
        StringUtil.printObject(list);
    }

    @Test
    public void testDistinct(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(6);
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        StringUtil.printObject(collect);
    }

    @Test
    public void t1(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1"));
        students.add(new Student(1,"2"));
        students.add(new Student(2,"3"));
        students.add(new Student(3,"4"));
        Map<Integer, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(s -> s.getId(), Collectors.mapping(s -> s, Collectors.toList())));
    }

    @Test
    public void t2(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1"));
        students.add(new Student(1,"2"));
        students.add(new Student(2,"3"));
        students.add(new Student(3,"4"));
        int size = students.size();
        for(int i=0;i<1000;i++){
            int ran = new Random().nextInt(size);
            System.out.print(ran);
            if(ran>=size){
                System.out.println("===>ran:"+ran+" size:"+size);
            }
        }
        System.out.println();
    }

    @Test
    public void t3(){
        try{
            System.out.println("===>start is end");
            return ;
        }catch (Exception e){

        }finally {
            System.out.println("====is finally");
        }
    }
}
