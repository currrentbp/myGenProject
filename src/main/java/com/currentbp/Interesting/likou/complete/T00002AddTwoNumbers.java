package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20181226
 */
public class T00002AddTwoNumbers {
    /*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void printListNode(ListNode listNode) {
        System.out.print("(");
        ListNode head = listNode;
        while (true) {
            System.out.print("" + head.val);
            if (head.next != null) {
                System.out.print(" -> ");
                head = head.next;
            } else {
                break;
            }
        }
        System.out.println(")");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = result;
        boolean flag = false;
        do {
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (flag ? 1 : 0);
            flag = value / 10 > 0;
            ListNode listNode = new ListNode(value % 10);
            if (null == head) {
                result = listNode;
                head = result;
            } else {
                head.next = listNode;
                head = listNode;
            }

            l1 = null == l1? null: l1.next;
            l2 = null == l2? null: l2.next;
        } while (l1 != null || l2 != null || flag);
        return result;
    }
    /*
    官方答案
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, current = result;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }

    @Test
    public void t1() {
        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        l1.next = l1_2;
        ListNode l1_3 = new ListNode(3);
        l1_2.next = l1_3;

        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        l2.next = l2_2;
        ListNode l2_3 = new ListNode(4);
        l2_2.next = l2_3;

        ListNode listNode = addTwoNumbers(l1, l2);
        printListNode(listNode);
    }
}
