package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<ListNode> allHeads = new ArrayList<>();
        ListNode current = head;
        while (null != current) {
            allHeads.add(current);
            current = current.next;
        }
        int size = allHeads.size();
        if (size == n && 1 == n) {
            return null;
        }
        if (size == n) {
            head = allHeads.get(size - n + 1);
            return head;
        }
        if (n == 1) {
            allHeads.get(size - 2).next = null;
            return head;
        }
        allHeads.get(size - n - 1).next = allHeads.get(size - n + 1);
        return head;
    }

    /*
    官网最佳答案
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null||n==0)
            return head;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            list.add(node);
            node = node.next;
        }
        int len=list.size();
        if(len==n){
            return head.next;
        }
        // the previous one
        node = list.get(len-n-1);
        node.next = node.next.next;
        return head;
    }
}
