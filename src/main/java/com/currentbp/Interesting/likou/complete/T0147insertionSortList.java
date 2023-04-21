package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/21 15:40
 */
public class T0147insertionSortList {
    /*
给定单个链表的头head，使用 插入排序 对链表进行排序，并返回排序后链表的头。
插入排序算法的步骤:
插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
对链表进行插入排序。
示例 1：
输入: head = [4,2,1,3]
输出: [1,2,3,4]
示例2：
输入: head = [-1,5,3,4,0]
输出: [-1,0,3,4,5]

     */

    @Test
    public void t1() {
        System.out.println(insertionSortList(new ListNode(Lists.newArrayList(4, 2, 1, 3))));
        System.out.println(insertionSortList(new ListNode(Lists.newArrayList(-1, 5, 3, 4, 0))));
    }

    /*
    官方答案
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}
