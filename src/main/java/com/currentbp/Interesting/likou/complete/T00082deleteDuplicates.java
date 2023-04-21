package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2023/4/20 20:49
 */
public class T00082deleteDuplicates {
    /*
给定一个已排序的链表的头head ，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。
示例 1：
输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：
输入：head = [1,1,1,2,3]
输出：[2,3]
     */


    @Test
    public void t1() {
        System.out.println(deleteDuplicates(new ListNode(Lists.newArrayList(1,2,3,3,4,4,5))));
        System.out.println(deleteDuplicates(new ListNode(Lists.newArrayList(1,1,1,2,3))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        Set<Integer> sameValues = findSameValue(head);

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        removeSameValue(newHead, sameValues);

        return newHead.next;
    }


    /*
    before->next->second->third
    1     ->2   ->3     ->4
     */
    private void removeSameValue(ListNode newHead, Set<Integer> sameValues) {
        ListNode before = newHead, next = newHead.next;
        while (next != null) {
            if (sameValues.contains(next.val)) {
                before.next = next.next;
                next = next.next;
            } else {
                before = before.next;
                next = next.next;
            }
        }
    }

    private Set<Integer> findSameValue(ListNode head) {
        Set<Integer> allValue = new HashSet<>();
        Set<Integer> sameValue = new HashSet<>();

        if (head == null) {
            return sameValue;
        }
        while (head != null) {
            if (allValue.contains(head.val)) {
                sameValue.add(head.val);
            } else {
                allValue.add(head.val);
            }
            head = head.next;
        }

        return sameValue;
    }

    /*
    官方解答
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempHead = new ListNode();
        tempHead.next = head;

        ListNode quick = head, slow = tempHead;
        while (quick.next != null) {
            if (quick.val == quick.next.val) {
                quick = quick.next;
            } else {
                if (slow.next != quick) {
                    slow.next = quick.next;
                } else {
                    slow = slow.next;
                }
                quick = quick.next;
            }
        }

        if (slow.next != quick) {
            slow.next = null;
        }

        return tempHead.next;
    }
}
