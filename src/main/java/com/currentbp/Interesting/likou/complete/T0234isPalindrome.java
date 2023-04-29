package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/21 22:09
 */
public class T0234isPalindrome {
    /*
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
示例 1：
输入：head = [1,2,2,1]
输出：true
示例 2：
输入：head = [1,2]
输出：false

     */

    @Test
    public void t1() {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        List<ListNode> newLists = new ArrayList<>();
        while (head != null) {
            newLists.add(head);
            head = head.next;
        }

        for (int i = 0; i <= newLists.size() / 2; i++) {
            if (newLists.get(i).val != newLists.get(newLists.size() - i - 1).val) {
                return false;
            }
        }

        return true;
    }
}
