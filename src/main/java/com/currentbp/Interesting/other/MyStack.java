package com.currentbp.Interesting.other;

import com.alibaba.fastjson.JSON;
import com.currentbp.util.all.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/13 16:02
 */
public class MyStack<T> {

    private List<T> sources = new ArrayList<>();
    private int size = -1;


    public synchronized void push(T o) {
        sources.add(++size, o);
        StringUtil.printObject("push source:"+ JSON.toJSONString(sources));
        StringUtil.printObject("push size:" + size);
    }

    public synchronized T pop() {
        if (size < 0) {
            return null;
        }
        T t = sources.get(size);
        size--;
        StringUtil.printObject("pop source:"+ JSON.toJSONString(sources));
        StringUtil.printObject("pop size:" + size);
        return t;
    }

    public synchronized boolean isEmpty() {
        return size > -1;
    }

    public synchronized int size() {
        return size + 1;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myStack.push(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Object pop = myStack.pop();
                StringUtil.printObject("result:" + pop);
            }
        }).start();
    }

}
