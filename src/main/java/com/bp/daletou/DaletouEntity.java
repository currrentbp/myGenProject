package com.bp.daletou;

import com.bp.util.all.StreamUtil;

import java.util.List;

/**
 * 大乐透号码
 *
 * @author current_bp
 * @createTime 20170503
 */
public class DaletouEntity {
    private String id;
    private int[] red = new int[5];
    private int[] blue = new int[2];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int[] getRed() {
        return red;
    }

    public void setRed(int[] red) {
        this.red = red;
    }

    public int[] getBlue() {
        return blue;
    }

    public void setBlue(int[] blue) {
        this.blue = blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DaletouEntity that = (DaletouEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(id + ":");

        for (int i = 0; i < 5; i++) {
            sb.append(red[i] + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(";");
        for (int i = 0; i < 2; i++) {
            sb.append(blue[i] + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }
}
