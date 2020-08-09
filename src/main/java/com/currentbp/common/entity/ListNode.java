package com.currentbp.common.entity;

import com.currentbp.util.all.CheckUtil;

import java.util.List;

/** 链表
 * @author baopan
 * @createTime 20190211
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode init(List<Integer> original) {
        if (CheckUtil.isEmpty(original)) {
            return null;
        }
        ListNode head = null, temp = null;
        for (Integer num : original) {
            ListNode listNode = new ListNode(num);
            if (null == head) {
                head = listNode;
                temp = head;
            } else {
                temp.next = listNode;
                temp = listNode;
            }
        }

        return head;
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
}
