package com.currentbp.Interesting.likou;

import com.currentbp.Interesting.likou.common.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author baopan
 * @createTime 2019/3/23 11:03
 */
public class T00025 {
    /*
    给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

示例 :

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    //https://leetcode-cn.com/problems/reverse-nodes-in-k-group/

    @Test
    public void t1() {
        ListNode listNode1 = ListNode.init(Lists.newArrayList(1, 2, 3, 4, 5));
        ListNode.printListNodes(reverseKGroup(listNode1,1));
        ListNode listNode2 = ListNode.init(Lists.newArrayList(1, 2, 3, 4, 5));
        ListNode.printListNodes(reverseKGroup(listNode2, 2));
        ListNode listNode3 = ListNode.init(Lists.newArrayList(1, 2, 3, 4, 5));
        ListNode.printListNodes(reverseKGroup(listNode3, 3));
        ListNode listNode4 = ListNode.init(Lists.newArrayList(1, 2, 3, 4, 5));
        ListNode.printListNodes(reverseKGroup(listNode4, 4));
        ListNode listNode5 = ListNode.init(Lists.newArrayList(1, 2));
        ListNode.printListNodes(reverseKGroup(listNode5, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        if (k <= 1) {
            return head;
        }

        ListNode result = new ListNode(0), newHead = result;
        ListNode current = head;
        ListNode tempHead = new ListNode(0), tempTail = tempHead;
        for (int i = 0; ; i++) {
            if (i == 0 || i % k != 0) {
                if (null == current) {
                    break;
                }
                tempTail.next = new ListNode(current.val);
                tempTail = tempTail.next;
                current = current.next;
            }
            if (i != 0 && i % k == 0) {
                ListNode fragment = tempHead.next;
                ListNode[] headAndTail = switchAll(fragment);
                result.next = headAndTail[0];
                result = headAndTail[1];
                tempHead.next = null;
                tempTail = tempHead;
                i = -1;
                if (null == current) {
                    break;
                }
            }
        }
        if (null != tempHead.next) {
            result.next = tempHead.next;
        }
        return newHead.next;
    }

    private ListNode[] switchAll(ListNode listNode) {
        ListNode[] result = new ListNode[2];
        ListNode head = new ListNode(0);
        ListNode tail = null;
        boolean flag = true;
        while (null != listNode) {
            ListNode temp = head.next;
            head.next = new ListNode(listNode.val);
            if (flag) {
                flag = false;
                tail = head.next;
            }
            head.next.next = temp;
            listNode = listNode.next;
        }
        listNode = head.next;
        result[0] = listNode;
        result[1] = tail;
        return result;
    }
}
