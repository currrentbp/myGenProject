package com.currentbp.common.model;

/**
 * @author baopan
 * @createTime 20210802
 */
public class Teacher extends Human{
    private Integer id;
    private String name ;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
