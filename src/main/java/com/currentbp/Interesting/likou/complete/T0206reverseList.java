package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/21 22:03
 */
public class T0206reverseList {
    /*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：
输入：head = [1,2]
输出：[2,1]
示例 3：
输入：head = []
输出：[]

     */

    @Test
    public void t1(){

    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode newLists = new ListNode(0);
        while(head != null){
            ListNode temp = head.next;
            head.next = null;
            ListNode next = newLists.next;
            newLists.next = head;
            newLists.next.next = next;
            head = temp;
        }

        return newLists.next;
    }
}
