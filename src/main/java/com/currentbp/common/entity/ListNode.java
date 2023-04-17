package com.currentbp.common.entity;

import com.currentbp.util.all.CheckUtil;

import java.util.List;

/**
 * 链表
 *
 * @author baopan
 * @createTime 20190211
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(List<Integer> original) {
        if (CheckUtil.isEmpty(original)) {
            return;
        }
        ListNode tail = this;
        this.val = original.get(0);

        for (int i = 1; i < original.size(); i++) {
            int num = original.get(i);
            tail.next = new ListNode(num);
            tail = tail.next;
        }
    }

    public static void printListNodes(ListNode original) {
        if (null == original) {
            System.out.println("is empty!");
        }

        ListNode temp = original;
        while (true) {
            System.out.print(temp.val);
            if (null == temp.next) {
                break;
            } else {
                temp = temp.next;
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            stringBuilder.append("" + head.val + "->");
            head = head.next;
        }
        stringBuilder.append("end");

        return stringBuilder.toString();
    }
}
