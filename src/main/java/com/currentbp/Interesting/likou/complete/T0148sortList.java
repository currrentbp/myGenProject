package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/21 20:34
 */
public class T0148sortList {
    /*
给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：
输入：head = []
输出：[]

     */

    @Test
    public void t1() {
        System.out.println(sortList2(new ListNode(Lists.newArrayList(4, 2, 1, 3))));
        System.out.println(sortList2(new ListNode(Lists.newArrayList(-1, 5, 3, 4, 0))));
    }

    /*
    超时了
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newListNode = new ListNode();

        while (head != null) {
            ListNode temp = head.next;
            head.next = null;

            doSort(newListNode, head);

            head = temp;
        }

        return newListNode.next;
    }

    private void doSort(ListNode newListNode, ListNode currentNode) {
        if (currentNode == null) {
            return;
        }
        if (newListNode.next == null) {
            newListNode.next = currentNode;
            return;
        }

        ListNode before = newListNode.next;

        if (currentNode.val <= before.val) {
            newListNode.next = currentNode;
            currentNode.next = before;
            return;
        }

        ListNode next = before.next;

        while (true) {
            if (before.val < currentNode.val && next == null) {
                before.next = currentNode;
                return;
            } else if (before.val < currentNode.val && currentNode.val <= next.val) {
                before.next = currentNode;
                currentNode.next = next;
                return;
            } else {
                before = next;
                next = next.next;
            }
        }
    }

    /*
    归并算法，没有超时
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = getLength(head);
        if (length <= 1) {
            return head;
        }
        int middle = length / 2;

        ListNode beforeList = new ListNode();
        beforeList.next = head;
        ListNode afterList = new ListNode();
        int index = 0;
        while (head != null) {
            index++;
            if (index == middle) {
                ListNode next = head.next;
                head.next = null;
                afterList.next = next;
                break;
            }
            head = head.next;
        }

        ListNode list1 = sortList2(beforeList.next);
        ListNode list2 = sortList2(afterList.next);
        return doMerge(list1, list2);
    }

    private ListNode doMerge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newListNode = new ListNode(), tail = newListNode;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                ListNode temp = list1.next;
                tail.next = list1;
                tail = tail.next;
                list1.next = null;
                list1 = temp;
            } else {
                ListNode temp = list2.next;
                tail.next = list2;
                tail = tail.next;
                list2.next = null;
                list2 = temp;
            }
        }

        return newListNode.next;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }
}
