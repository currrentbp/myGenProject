package com.currentbp.collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用两个栈实现队列的效果
 *
 * @author current_bp
 * @createTime 20170620
 */
public class TwoStackToQueue {
    private static Logger logger = LoggerFactory.getLogger(TwoStackToQueue.class);

    private Stack<Integer> stackA = new Stack<Integer>();
    private Stack<Integer> stackB = new Stack<Integer>();
    private Object lock = new Object();


    @Test
    public void test1() {
        push(1);
        push(2);
        push(3);
        push(4);

        while (true) {
            if (isEmpty()) {
                break;
            }
            logger.info("===>value:" + pop());
        }
        logger.info("=======================================");

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        push(list);
        logger.info("===>value:" + pop());
        push(3);
        logger.info("===>value:" + pop());
        push(4);
        while (true) {
            if (isEmpty()) {
                break;
            }
            logger.info("===>value:" + pop());
        }
    }

    public boolean push(List<Integer> list) {
        if (null == list || 0 == list.size()) {
            return false;
        }
        synchronized (lock) {
            int i = 0, j = 0;
            for (; i < list.size(); i++) {
                int value1 = stackA.push(list.get(i));
                if (list.get(i) == value1) {
                    j++;
                }
            }
            if (i == j) {
                return true;
            }
        }
        return false;
    }

    public boolean push(int value) {
        synchronized (lock) {
            int value1 = stackA.push(value);
            if (value == value1) {
                return true;
            }
        }
        return false;
    }

    public int pop() {
        synchronized (lock) {
            if (!stackB.isEmpty()) {
                return stackB.pop();
            } else {
                //如果B栈中为空，则从A栈中将数据全部拿到B栈中，然后在从B栈中推出一个数
                while (true) {
                    if (stackA.isEmpty()) {
                        break;
                    } else {
                        stackB.push(stackA.pop());
                    }
                }

                //获取数据
                return stackB.pop();
            }
        }
    }

    public boolean isEmpty() {
        synchronized (lock) {
            if (stackA.isEmpty() && stackB.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
