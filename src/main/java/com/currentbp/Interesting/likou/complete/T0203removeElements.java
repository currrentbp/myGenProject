package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/21 21:56
 */
public class T0203removeElements {
    /*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
示例 1
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：
输入：head = [], val = 1
输出：[]
示例 3：
输入：head = [7,7,7,7], val = 7
输出：[]

     */
    @Test
    public void t1() {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode before = newHead, next = before.next;

        while (next != null) {
            if (next.val == val) {
                before.next = next.next;
                next = before.next;
                continue;
            } else {
                before = next;
                next = next.next;
            }
        }
        return newHead.next;
    }
}
