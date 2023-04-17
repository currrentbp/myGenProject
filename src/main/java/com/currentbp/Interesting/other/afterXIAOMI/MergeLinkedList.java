package com.currentbp.Interesting.other.afterXIAOMI;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/4/8 16:56
 */
public class MergeLinkedList {
    /*
     给定一个链表，奇数位是升序的，偶数位是降序的，返回一个全部是升序的链表
解题思路：1、先将无序的链表拆解成两个有序的链表，
2、再将两个链表再组成一个新的链表
     */
    @Test
    public void t1() {
        System.out.println(merge(new ListNode(Lists.newArrayList(1, 3, 2, 2, 3, 1))));
    }

    private ListNode merge(ListNode sources) {
        System.out.println(sources);
        if (sources == null) {
            return sources;
        }
        ListNode upNodes = new ListNode(Integer.MIN_VALUE);
        ListNode downNodes = new ListNode(Integer.MIN_VALUE);
        ListNode upNodesTail = upNodes;

        ListNode temp = sources;
        int i = 0;
        while (temp != null) {
            i++;
            ListNode next = temp.next;
            //偶数
            if (i % 2 == 0) {
                ListNode next1 = downNodes.next;
                downNodes.next = temp;
                temp.next = next1;
            } else {
                //奇数
                upNodesTail.next = temp;
                upNodesTail = temp;
                temp.next = null;
            }
            temp = next;
        }
        System.out.println(upNodes.next);
        System.out.println(downNodes.next);

        return doMerge(upNodes.next, downNodes.next);
    }

    private ListNode doMerge(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }

        ListNode result = new ListNode(0);
        ListNode tail = result;
        while (one != null || two != null) {
            if (one == null) {
                tail.next = two;
                break;
            }
            if (two == null) {
                tail.next = one;
                break;
            }
            if (one.val < two.val) {
                ListNode temp = one.next;
                one.next = null;
                tail.next = one;
                one = temp;
            } else {
                ListNode temp = two.next;
                two.next = null;
                tail.next = two;
                two = temp;
            }
            tail = tail.next;
        }

        return result.next;
    }
}
