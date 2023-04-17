package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20201219
 */
public class T0061rotateRight {
    /*
给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
示例1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例2:
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步:0->1->2->NULL
向右旋转 4 步:2->0->1->NULL
     */

    @Test
    public void t1() {
        StringUtil.printObject(rotateRight(new ListNode(Lists.newArrayList(1, 2, 3, 4, 5)), 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        if(0 == k){
            return head;
        }
        ListNode currentNode = head;
        int size = 0;
        while (null != currentNode) {
            size++;
            currentNode = currentNode.next;
        }

        int remain = k % size;
        if(0 == remain){
            return head;
        }
        int before = size - remain;

        ListNode newHead = head;
        ListNode beforeNode = head;
        for (int i = 0; i < before; i++) {
            beforeNode = newHead;
            newHead = newHead.next;
        }
        beforeNode.next = null;
        ListNode tempTail = newHead;
        while (null != tempTail.next) {
            tempTail = tempTail.next;
        }

        tempTail.next = head;

        return newHead;
    }
}
