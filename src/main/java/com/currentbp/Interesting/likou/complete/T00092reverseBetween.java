package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/20 21:38
 */
public class T00092reverseBetween {
    /*
给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
示例 1：
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：
输入：head = [5], left = 1, right = 1
输出：[5]

     */

    @Test
    public void t1() {
        System.out.println(reverseBetween(new ListNode(Lists.newArrayList(1, 2, 3, 4, 5)), 2, 4));
        System.out.println(reverseBetween(new ListNode(Lists.newArrayList( 5)), 1, 1));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode one = new ListNode(0), oneBefore = one;
        ListNode two = new ListNode(0), twoTail = null;
        ListNode third = new ListNode(0), thirdBefore = third;

        int index = 1;
        boolean isFirst = true;
        while (head != null) {
            ListNode headNext = head.next;
            if (index < left) {
                oneBefore.next = head;
                oneBefore = oneBefore.next;
                oneBefore.next = null;
            } else if (left <= index && index <= right) {
                ListNode temp = two.next;
                two.next = head;
                two.next.next = temp;
                if (isFirst) {
                    twoTail = head;
                    isFirst = false;
                }
            } else {
                thirdBefore.next = head;
                thirdBefore = thirdBefore.next;
                thirdBefore.next = null;
            }

            head = headNext;
            index++;
        }
        //整合3个列表
        if (two.next != null) {
            oneBefore.next = two.next;
            oneBefore = twoTail;
        }
        oneBefore.next = third.next;

        return one.next;
    }
}
