package com.currentbp.Interesting.likou.offer.complete;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221219
 */
public class T030MinStack {
    /**
     * initialize your data structure here.
     */
    Integer minNum = null;
    List<Integer> lists = new ArrayList<>();

    public T030MinStack() {

    }

    public void push(int x) {
        lists.add(0, x);
        if (minNum == null) {
            minNum = x;
            return;
        }
        if (x < minNum) {
            minNum = x;
        }
    }

    public void pop() {
        if (lists.size() > 0) {
            lists.remove(0);
            minNum = doGetMin();
        }
    }

    public int top() {
        if (lists.size() > 0) {
            Integer top = lists.get(0);
            return top;
        }
        return -1;
    }

    private Integer doGetMin() {
        if (lists.size() == 0) {
            return null;
        }
        Integer temp = lists.get(0);
        for (Integer x : lists) {
            if (x < temp) {
                temp = x;
            }
        }
        return temp;
    }

    public int min() {
        return minNum == null ? 0 : minNum;
    }

    public static void main(String[] args) {
        T030MinStack t030MinStack = new T030MinStack();
    }
}
