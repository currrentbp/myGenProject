package com.currentbp.common.model;

/**
 * @author current_bp
 * @createTime 20170926
 */
public class Persion extends Human {
    private Integer id;
    private String name;

    public Persion() {
    }

    public Persion(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persion persion = (Persion) o;

        return id != null ? id.equals(persion.id) : persion.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
