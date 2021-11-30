package com.currentbp.common.model;

import java.util.List;

/**
 * @author baopan
 * @createTime 20210802
 */
public class Teacher extends Human{
    private Integer id;
    private String name ;
    private Course course;
    private List<Course> myCourses;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(List<Course> myCourses) {
        this.myCourses = myCourses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", myCourses=" + myCourses +
                "} " + super.toString();
    }
}
