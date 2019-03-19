package com.currentbp.Interesting.likou.complete;

import com.currentbp.Interesting.likou.common.ListNode;
import com.currentbp.common.entity.Student;
import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2019/3/16 12:03
 */
public class T00023 {
    /*
    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
     */
    //https://leetcode-cn.com/problems/merge-k-sorted-lists/
    @Test
    public void t1() {
        ListNode listNode1 = ListNode.init(Lists.newArrayList(1, 4, 5));
        ListNode listNode2 = ListNode.init(Lists.newArrayList(1, 3, 4));
        ListNode listNode3 = ListNode.init(Lists.newArrayList(2, 6));
        List<ListNode> listNodes = Lists.newArrayList(listNode1, listNode2, listNode3);
        ListNode[] listNodes1 = ListUtil.list2Array(listNodes);
        ListNode listNode = mergeKLists(listNodes1);
        ListNode.printListNodes(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        } else if (1 == lists.length) {
            return lists[0];
        }
        //采用两两合并的方式
        List<ListNode> listNodes = ListUtil.array2List(lists);

        List<ListNode> temp = new ArrayList<>();
        for (int i = 0; i < (listNodes.size() / 2 + 1); i++) {
            if (1 == listNodes.size()) {
                break;
            }

            if (i * 2 + 1 < listNodes.size()) {
                ListNode listNode = mergeTwoListNodes(listNodes.get(i * 2), listNodes.get(i * 2 + 1));
                temp.add(listNode);
            } else {
                temp.add(listNodes.get(i * 2));
            }

            if (i * 2 == listNodes.size() - 1 || i * 2 + 1 == listNodes.size() - 1) {
                listNodes = temp;
                temp = new ArrayList<>();
                i = -1;
            }
        }
        return listNodes.get(0);
    }

    /*
    官网最佳答案
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high)
            return lists[low];
        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                ListNode next = l2.next;
                l2.next = cur.next;
                cur.next = l2;
                l2 = next;
            }
            cur = cur.next;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }

    private ListNode mergeTwoListNodes(ListNode listNode1, ListNode listNode2) {
        ListNode head, result = new ListNode(0);
        head = result;
        while (null != listNode1 || null != listNode2) {
            if (null == listNode1) {
                result.next = listNode2;
                break;
            }
            if (null == listNode2) {
                result.next = listNode1;
                break;
            }

            if (listNode1.val <= listNode2.val) {
                result.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            } else {
                result.next = new ListNode(listNode2.val);
                listNode2 = listNode2.next;
            }
            result = result.next;
        }
        return head.next;
    }
}
