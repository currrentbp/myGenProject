package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.ListNode;

/**
 * @author baopan
 * @createTime 20221220
 */
public class T024reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode temp = head;
        ListNode result = new ListNode(0);
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = null;

            ListNode next1 = result.next;
            result.next = temp;
            temp.next = next1;

            temp = next;
        }
        return result.next;
    }
}
