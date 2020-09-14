package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/31 10:15
 */
public class T006ReversePrint {
    /*
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    示例 1：
    输入：head = [1,3,2]
    输出：[2,3,1]
    限制：
    0 <= 链表长度 <= 10000
     */
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        while (null != head) {
            result.add(head.val);
            head = head.next;
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(result.size() - 1 - i);
        }
        return r;
    }
}
