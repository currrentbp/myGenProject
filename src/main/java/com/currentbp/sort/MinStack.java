package com.currentbp.sort;

import org.junit.Test;

import java.util.*;

/**
 * 获取栈的最小值，要求获取方法是o1的
 *
 * @author baopan
 * @createTime 2020/6/23 16:19
 */
public class MinStack {

    private Stack<Integer> originalStack = new Stack<>();
    private List<Integer> linkedList = new LinkedList<>();

    @Test
    public void t1() {
        List<Integer> l1 = new ArrayList<>();
        l1.add(0,1);
        push(1);
        push(2);
        push(3);
        System.out.println("min:" + getMin());
        Integer pop = pop();
        System.out.println("pop:" + pop + " min:" + getMin() + " stack:" + originalStack);
        Integer pop2 = pop();
        System.out.println("pop2:" + pop2 + " min:" + getMin() + " stack:" + originalStack);

    }

    public Integer getMin() {
        return linkedList.size() == 0 ? null : linkedList.get(0);
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
        if (linkedList.size() <= 0) {
            return;
        }
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            if (pop.equals(iterator.next())) {
                iterator.remove();
                break;
            }
        }
    }

    private void add2List(Integer x) {
        if (0 == linkedList.size()) {
            linkedList.add(x);
            return;
        }

        int index = linkedList.size();
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) < x) {
                continue;
            } else {
                index = i;
            }
        }

        linkedList.add(index, x);
        System.out.println(linkedList);
    }
}
