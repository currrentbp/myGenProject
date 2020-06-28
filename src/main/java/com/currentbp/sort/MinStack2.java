package com.currentbp.sort;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 获取栈的最小值，要求获取方法是o1的
 *
 * @author baopan
 * @createTime 2020/6/23 16:19
 */
public class MinStack2 {

    private Stack<Integer> originalStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    @Test
    public void t1() {
        Integer newCapacity = -1999000000;
        Integer MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;
        Integer x = newCapacity - MAX_ARRAY_SIZE ;
        System.out.println("x:"+x+" max:"+Integer.MAX_VALUE);

        push(3);
        push(1);
        push(2);
        System.out.println("min:" + getMin());
        Integer pop = pop();
        System.out.println("pop:" + pop + " min:" + getMin() + " stack:" + originalStack);
        Integer pop2 = pop();
        System.out.println("pop2:" + pop2 + " min:" + getMin() + " stack:" + originalStack);

    }

    public Integer getMin() {
        return minStack.size() == 0 ? null : minStack.peek();
    }

    public void push(Integer x) {
        originalStack.push(x);

        add2List(x);
    }

    public Integer pop() {
        Integer pop = originalStack.pop();
        removeFromList(pop);
        return pop;
    }

    private void removeFromList(Integer pop) {
        if (minStack.size() <= 0) {
            return;
        }
        minStack.pop();
    }

    private void add2List(Integer x) {
        if(minStack.size()<=0){
            minStack.push(x);
            return;
        }
        Integer peek = minStack.peek();
        if(x<=peek){
            minStack.push(x);
        }else{
            minStack.push(peek);
        }
        System.out.println(minStack);
    }
}
