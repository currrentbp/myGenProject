package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.CheckUtil;

import java.util.List;

/**
 * @author baopan
 * @createTime 20190211
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
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

        while (true) {
            System.out.print(original.val);
            if (null == original.next) {
                break;
            } else {
                original = original.next;
            }
        }
        System.out.println();
    }
}
