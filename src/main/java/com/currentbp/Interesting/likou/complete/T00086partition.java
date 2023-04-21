package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/20 21:16
 */
public class T00086partition {
    /*
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你应当 保留 两个分区中每个节点的初始相对位置。
示例 1
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
示例 2：
输入：head = [2,1], x = 2
输出：[1,2]

     */


    @Test
    public void t1() {
        System.out.println(partition(new ListNode(Lists.newArrayList(1, 4, 3, 2, 5, 2)), 3));
        System.out.println(partition(new ListNode(Lists.newArrayList(2, 1)), 2));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode list1 = new ListNode(0), list1Before = list1;

        ListNode list2 = new ListNode(0), list2Before = list2;

        /*
        head->next->second->third
        0   ->1   ->2     ->3
         */
        while (head != null) {
            ListNode temp = head.next;
            if (head.val >= x) {
                list2Before.next = head;
                list2Before = list2Before.next;
                list2Before.next = null;
            } else {
                list1Before.next = head;
                list1Before = list1Before.next;
                list1Before.next = null;
            }
            head = temp;
        }
        list1Before.next = list2.next;

        return list1.next;
    }
}
