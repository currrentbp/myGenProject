package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/25 9:26
 */
public class T1171removeZeroSumSublists {

    /*
给你一个链表的头节点head，请你编写代码，反复删去链表中由 总和值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
删除完毕后，请你返回最终结果链表的头节点。
你可以返回任何满足题目要求的答案。
（注意，下面示例中的所有序列，都是对ListNode对象序列化的表示。）
示例 1：
输入：head = [1,2,-3,3,1]
输出：[3,1]
提示：答案 [1,2,1] 也是正确的。
示例 2：
输入：head = [1,2,3,-3,4]
输出：[1,2,4]
示例 3：
输入：head = [1,2,3,-3,-2]
输出：[1]

解题思路：
1、制定一个list，按照链表的顺序排序
2、将链表元素放到map中，
     */
    @Test
    public void t1(){
        System.out.println(removeZeroSumSublists(new ListNode(Lists.newArrayList(0))));
        System.out.println(removeZeroSumSublists(new ListNode(Lists.newArrayList(1,2,-3,3,1))));
        System.out.println(removeZeroSumSublists(new ListNode(Lists.newArrayList(1,2,3,-3,4))));
        System.out.println(removeZeroSumSublists(new ListNode(Lists.newArrayList(1,2,3,-3,-2))));

    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }


        List<ListNode> lists = new ArrayList<>();
        while (head != null) {
            lists.add(head);
            head = head.next;
        }

        doRemove(lists);

        return doMerge(lists);
    }

    private ListNode doMerge(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        ListNode newHead = new ListNode(), head = newHead;
        for (int i = 0; i < lists.size(); i++) {
            head.next = lists.get(i);
            head = head.next;
        }
        head.next = null;
        return newHead.next;
    }

    public boolean doRemove(List<ListNode> lists) {
        if (lists.size() == 0) {
            return true;
        }

        boolean isOk = true;
        flag:
        for (int i = 0; i < lists.size(); i++) {
            int sum = 0;
            for (int j = i; j < lists.size(); j++) {
                sum += lists.get(j).val;
                if (sum == 0) {
                    doRemove(lists, i, j);
                    isOk = false;
                    break flag;
                }
            }
        }
        if (isOk) {
            return true;
        }

        return doRemove(lists);
    }

    private void doRemove(List<ListNode> lists, int left, int right) {
        if (lists.size() == 0) {
            return;
        }
        if (left == right) {
            lists.remove(left);
            return;
        }
        if (left > right) {
            return;
        }
        for (; left <= right; right--) {
            lists.remove(left);
        }
    }
}
