package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/20 21:06
 */
public class T00083deleteDuplicates {
    /*
给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
示例 1：
输入：head = [1,1,2]
输出：[1,2]
示例 2：
输入：head = [1,1,2,3,3]
输出：[1,2,3]
     */

    @Test
    public void t1() {
        System.out.println(deleteDuplicates(new ListNode(Lists.newArrayList(1, 1, 2))));
        System.out.println(deleteDuplicates(new ListNode(Lists.newArrayList(1, 1, 2, 3, 3))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        /*
        before->next->second->third
0->     1     ->2   ->3     ->4
         */
        ListNode before = newHead.next, next = before.next;
        while (next != null) {
            if (before.val == next.val) {
                before.next = next.next;
                next = next.next;
            } else {
                before = next;
                next = next.next;
            }
        }

        return newHead.next;
    }
}
