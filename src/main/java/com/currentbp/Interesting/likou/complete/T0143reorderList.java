package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/20 23:27
 */
public class T0143reorderList {
    /*
给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例 1：
输入：head = [1,2,3,4]
输出：[1,4,2,3]
示例 2：
输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3]

     */

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> lists = new ArrayList<>();
        ListNode newBefore = head;
        while (newBefore != null) {
            lists.add(newBefore);
            newBefore = newBefore.next;
        }

        int left = 0, right = lists.size() - 1;
        ListNode before = new ListNode(0);
        while (left <= right) {
            if (left == right) {
                before.next = lists.get(left);
                before.next.next = null;
            }
            //先取左边的
            before.next = lists.get(left);
            before = before.next;
            before.next = null;
            left++;
            //再取右边的
            before.next = lists.get(right);
            before = before.next;
            before.next = null;
            right--;
        }

    }
}
