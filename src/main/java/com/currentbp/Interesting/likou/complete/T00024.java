package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2019/3/23 10:08
 */
public class T00024 {
    /*
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    //https://leetcode-cn.com/problems/swap-nodes-in-pairs/
    @Test
    public void t1(){
        ListNode listNodes = new ListNode(Lists.newArrayList(1));
        ListNode.printListNodes(swapPairs(listNodes));
    }
    public ListNode swapPairs(ListNode head) {
        if(null == head){
            return null;
        }

        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode before = listNode,current = head.next;

        do{
            if(null == current){
                break;
            }
            ListNode temp = before.next;
            before.next = current;
            temp.next = current.next;
            current.next = temp;
            current = temp;

            if(null == current.next){
                break;
            }
            before = current;
            current = current.next.next;

        }while(true);
        return listNode.next;
    }

    /**
     * 官网最佳答案
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;

        head.next.next = swapPairs(head.next.next);
        return head;
    }
}
