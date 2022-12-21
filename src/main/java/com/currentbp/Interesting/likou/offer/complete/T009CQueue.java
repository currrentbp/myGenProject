package com.currentbp.Interesting.likou.offer.complete;

import java.util.Stack;

/**
 * @author baopan
 * @createTime 20221219
 */
public class T009CQueue {
    private Stack<Integer> first = new Stack<>();
    private Stack<Integer> second = new Stack<>();

    public T009CQueue() {

    }

    public void appendTail(int value) {
        while (!first.empty()){
            second.push(first.pop());
        }
        second.push(value);
        first = new Stack<>();
        while(!second.empty()){
            first.push(second.pop());
        }
    }

    public int deleteHead() {
        if(first.isEmpty()){
            return -1;
        }
        return first.pop();
    }
}
