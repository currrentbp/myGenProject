package com.currentbp.Interesting.likou;

import com.currentbp.common.entity.ListNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/25 10:27
 */
public class T1019nextLargerNodes {
    /*
给定一个长度为n的链表head
对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。
如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0。
示例 1：
输入：head = [2,1,5]
输出：[5,5,0]
示例 2：
输入：head = [2,7,4,3,5]
输出：[7,0,5,5,0]

     */
    @Test
    public void t1() {
        StringUtil.printObject(nextLargerNodes(new ListNode(Lists.newArrayList(2, 1, 5))));
        StringUtil.printObject(nextLargerNodes(new ListNode(Lists.newArrayList(2, 7, 4, 3, 5))));
        StringUtil.printObject(nextLargerNodes(new ListNode(Lists.newArrayList(1, 7, 5, 1, 9, 2, 5, 1))));
    }


    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode newHead = head;
        while (newHead != null) {
            size++;
            newHead = newHead.next;
        }

        int[] sources = new int[size];
        Arrays.fill(sources, -1);

        List<ListNode> lists = doListNode2List(head);

        for (int i = 0; i < lists.size(); i++) {
            doRemark(lists, i, sources);
        }
        return sources;
    }

    private void doRemark(List<ListNode> lists, int index, int[] sources) {
        int currentValue = lists.get(index).val;
        if (index == 0) {
            sources[index] = 0;
            return;
        }
        if (lists.get(index - 1).val < currentValue) {
            int end = index, start = end;
            while (start - 1 >= 0) {
                if (lists.get(start - 1).val < currentValue) {
                    start--;
                } else {
                    break;
                }
            }
            for (; start < end; start++) {
                sources[start] = currentValue;
            }
            sources[end] = 0;
        }
    }

    private List<ListNode> doListNode2List(ListNode head) {
        List<ListNode> result = new ArrayList<>();
        while (head != null) {
            result.add(head);
            head = head.next;
        }
        return result;
    }
}
