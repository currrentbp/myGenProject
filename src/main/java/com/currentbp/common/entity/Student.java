package com.currentbp.common.entity;

import java.util.List;

/**
 * 学生类
 *
 * @author current_bp
 * @createTime 20170831
 */
public class Student {
    private Integer id;
    private String name;
    private List<String> hobbies;
    private Course course;
    private List<Course> myCourses;

    public Student(){}
    public Student(Integer id,String name){
        this.id = id;
        this.name = name;
    }
    public Student(Integer id,String name,List<Course> myCourses){
        this.id = id;
        this.name = name;
        this.myCourses = myCourses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Course> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(List<Course> myCourses) {
        this.myCourses = myCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", course=" + course +
                ", myCourses=" + myCourses +
                '}';
    }
}
