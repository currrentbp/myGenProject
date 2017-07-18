package com.bp.bean.copy;

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
}
