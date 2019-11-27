package com.currentbp.test;

import com.currentbp.common.entity.Course;
import com.currentbp.common.entity.Student;
import com.currentbp.common.entity.Subject;
import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author baopan
 * @createTime 20190823
 */
public class Java8Test {

    @Test
    public void k1k2sum(){
        List<Student> students = Lists.newArrayList(new Student(1,"b1")
                ,new Student(2,"b2")
                ,new Student(3,"b1")
                ,new Student(4,"b3"));

        Map<String, Integer> collect = students.stream().collect(Collectors.toMap(Student::getName, Student::getId, (k1, k2) -> k1 + k2));
        for (Map.Entry<String, Integer> stringIntegerEntry : collect.entrySet()) {
            System.out.println("key111:"+stringIntegerEntry.getKey()+" value:"+stringIntegerEntry.getValue());
        }
    }

    @Test
    public void filter(){
        List<Student> students = Lists.newArrayList(new Student(1,"s1"),new Student(2,"s2"));
        List<Student> collect = students.stream().filter(s -> s.getId().equals(10)).collect(toList());
        ListUtil.printList(collect);
    }

    @Test
    public void sum(){
        List<Student> students = Lists.newArrayList(new Student(1,"s1"),new Student(2,"s2"));
        int sum = students.stream().mapToInt(Student::getId).sum();
        System.out.println(sum);
        List<Student> students1 = new ArrayList<>();
        int sum1 = students1.stream().mapToInt(Student::getId).sum();
        System.out.println(sum1);
    }

    @Test
    public void t6(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1", Lists.newArrayList(new Course(1,"c1",new Subject(1,"s1")),new Course(2,"c2"))));
        students.add(new Student(2,"2",Lists.newArrayList(new Course(3,"c3"))));
        students.add(new Student(3,"3",Lists.newArrayList(new Course(4,"c4"),new Course(5,"c5"))));

        List<Course> allCourses = students.stream().flatMap(o -> o.getMyCourses().stream()).collect(toList());
        Course course = allCourses.get(0);
        course.setName("ssssssssssssssssssssssssss");
        course.getSubject().setName("sssfffffff");
        ListUtil.printList(allCourses);
        ListUtil.printList(students);
    }

    @Test
    public void t5(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1", Lists.newArrayList(new Course(1,"c1"),new Course(2,"c2"))));
        students.add(new Student(2,"2",Lists.newArrayList(new Course(3,"c3"))));
        students.add(new Student(3,"3",Lists.newArrayList(new Course(4,"c4"),new Course(5,"c5"))));

        List<Course> result = new ArrayList<>();
        students.forEach(s->{result.addAll(s.getMyCourses());});
        Course course = result.get(0);
        course.setName("ssssssssssssssssssssssssss");
        ListUtil.printList(result);
        ListUtil.printList(students);
    }

    @Test
    public void t4(){
        //结果：修改了，说明stream是浅拷贝
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1", Lists.newArrayList(new Course(1,"c1"),new Course(2,"c2"))));
        students.add(new Student(2,"2",Lists.newArrayList(new Course(3,"c3"))));
        students.add(new Student(3,"3",Lists.newArrayList(new Course(4,"c4"),new Course(5,"c5"))));

        List<Course> allCourses = students.stream().flatMap(o -> o.getMyCourses().stream()).collect(toList());
        Course course = allCourses.get(0);
        course.setName("ssssssssssssssssssssssssss");
        ListUtil.printList(allCourses);
        ListUtil.printList(students);
    }


    @Test
    public void t3(){
        //结果：修改了，说明stream是浅拷贝
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1"));
        students.add(new Student(2,"2"));
        students.add(new Student(3,"3"));
        List<Student> students1 = students.stream().filter(s -> s.getId().equals(1) || s.getId().equals(2)).collect(toList());
        Student student = students1.get(0);
        student.setName("fffffff");
        ListUtil.printList(students);
        ListUtil.printList(students1);
    }
    @Test
    public void t3_1(){

        List<Integer> students = new ArrayList<>();
        students.add(1);
        students.add(2);
        students.add(3);
        students.forEach(i->{if(i==1)i++;System.out.println(i);});
        ListUtil.printList(students);
    }


    @Test
    public void t21(){
        String content  = "9999,12";
        System.out.println(content.substring(5));
    }
    @Test
    public void t11(){
        Integer num = null;
        int f = num - 3;
        System.out.println(f);
    }
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
