package com.currentbp.bean.copy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author current_bp
 * @createTime 20170718
 */
public class First {
    private Integer f1;
    private String s1;
    private Date date;
    private Second second;
    List<Other> others;
    List<String> others1;
    String[] others2;


    public Integer getF1() {
        return f1;
    }

    public void setF1(Integer f1) {
        this.f1 = f1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public List<Other> getOthers() {
        return others;
    }

    public void setOthers(List<Other> others) {
        this.others = others;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getOthers1() {
        return others1;
    }

    public void setOthers1(List<String> others1) {
        this.others1 = others1;
    }

    public String[] getOthers2() {
        return others2;
    }

    public void setOthers2(String[] others2) {
        this.others2 = others2;
    }

    @Override
    public String toString() {
        return "First{" +
                "f1=" + f1 +
                ", s1='" + s1 + '\'' +
                ", date=" + date +
                ", second=" + second +
                ", others=" + others +
                ", others1=" + others1 +
                ", others2=" + Arrays.toString(others2) +
                '}';
    }
}
