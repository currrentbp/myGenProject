package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190211
 */
public class T00021 {
    /*
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
     */

    @Test
    public void t1() {
        ListNode listNode = ListNode.init(Lists.newArrayList(1,2,4));
        ListNode listNode2 = ListNode.init(Lists.newArrayList(1,3,4));
        ListNode.printListNodes(listNode);
        ListNode.printListNodes(listNode2);
        ListNode listNode1 = mergeTwoLists(listNode, listNode2);
        ListNode.printListNodes(listNode1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }
        ListNode temp = new ListNode(0);
        ListNode index1 = l1,index2 = l2,head = temp;
        while(true){
            if(index1 == null && index2 == null){
                break;
            }
            if(index1 == null){
                temp.next= new ListNode(index2.val);
                index2 = index2.next;
                temp = temp.next;
                continue;
            }
            if(index2 == null){
                temp.next= new ListNode(index1.val);
                index1 = index1.next;
                temp = temp.next;
                continue;
            }
            if(index1.val<index2.val){
                temp.next=new ListNode(index1.val);
                index1 = index1.next;
            }else{
                temp.next=new ListNode(index2.val);
                index2 = index2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
    /*
    官网最佳答案
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1!=null && l2 != null){
            if(l1.val<=l2.val){
                l1 = l1.next;
            }else{
                ListNode next = l2.next;

                l2.next = cur.next;
                cur.next = l2;

                l2 = next;
            }
            cur = cur.next;
        }
        if(l2!=null){
            cur.next = l2;
        }
        return dummy.next;
    }

}
