package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 1/4/2023 3:29 PM
 */
public class T052getIntersectionNode {


    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }
        if (headB == null) {
            return null;
        }

        List<ListNode> listA = new ArrayList<>();
        List<ListNode> listB = new ArrayList<>();

        while (headA != null) {
            listA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            listB.add(headB);
            headB = headB.next;
        }

        ListNode result = null;
        for (int i = listA.size() - 1, j = listB.size() - 1; i >= 0 && j >= 0; ) {
            if (listA.get(i).val == listB.get(j).val) {
                result = listA.get(i);
                i--;
                j--;
            } else {
                break;
            }
        }

        return result;
    }
}
