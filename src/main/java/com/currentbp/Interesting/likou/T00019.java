package com.currentbp.Interesting.likou;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190202
 */
public class T00019 {
    /*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。
     */
//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
    //todo not work
    @Test
    public void t1() {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n <= 0) {
            return head;
        }
        ListNode current = head;
        ListNode before = null;
        int index = 0;
        while (current != null) {
            if (index == n) {
                ListNode temp = current.next;
                before.next = temp;
                break;
            } else {
                before = current;
                index++;
            }
        }
        return head;
    }
}
