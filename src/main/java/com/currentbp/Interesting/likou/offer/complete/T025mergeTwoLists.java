package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.ListNode;

/**
 * @author baopan
 * @createTime 1/3/2023 5:34 PM
 */
public class T025mergeTwoLists {
    /*
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：
0 <= 链表长度 <= 1000

     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode currentResult = result;

        ListNode l1Node = l1;
        ListNode l2Node = l2;

        while(l1Node != null || l2Node != null){
            if(null == l1Node){
                currentResult.next=l2Node;
                break;
            }
            if(null == l2Node){
                currentResult.next = l1Node;
                break;
            }

            if(l1Node.val<l2Node.val){
                ListNode next = l1Node.next;
                l1Node.next= null;
                currentResult.next = l1Node;
                currentResult = l1Node;
                l1Node = next;
            }else{
                ListNode next = l2Node.next;
                l2Node.next = null;
                currentResult.next = l2Node;
                currentResult = l2Node;
                l2Node = next;
            }
        }
        return result.next;
    }
}
