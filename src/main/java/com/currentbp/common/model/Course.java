package com.currentbp.common.model;

/**
 * 学科
 * @author current_bp
 * @createTime 20170831
 */
public class Course {
    private Integer id;
    private String name;
    private Subject subject;

    public Course(){}
    public Course(Integer id,String name){this.id=id;this.name=name;}
    public Course(Integer id,String name,Subject subject){this.id=id;this.name=name;this.subject=subject;}

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id != null ? id.equals(course.id) : course.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
