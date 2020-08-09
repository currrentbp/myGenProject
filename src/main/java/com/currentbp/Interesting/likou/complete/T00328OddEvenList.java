package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/8 12:50
 */
public class T00328OddEvenList {
    /*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
示例 1:
输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:
输入: 2->1->3->5->6->4->7->NULL
输出: 2->3->6->7->1->5->4->NULL
说明:
应当保持奇数节点和偶数节点的相对顺序。
链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
解决思路：
1、使用游标定位位置，偶数位置的节点单独拉出来作为一个新的列表，直到链表为的next为null才合并两个链表
2、由于空间复杂度是0(1)，则不能使用其他的空间
     */
    @Test
    public void t1() {
        List<Integer> source1 = Lists.newArrayList(1);
        List<Integer> source2 = Lists.newArrayList(1, 2);
        List<Integer> source3 = Lists.newArrayList(1, 2, 3);
        List<Integer> source4 = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> source5 = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> source6 = Lists.newArrayList(1, 2, 3, 4, 5,6);
        ListNode temp1 = ListNode.init(source1);
        ListNode temp2 = ListNode.init(source2);
        ListNode temp3 = ListNode.init(source3);
        ListNode temp4 = ListNode.init(source4);
        ListNode temp5 = ListNode.init(source5);
        ListNode temp6 = ListNode.init(source6);

//        ListNode listNode1 = oddEvenList(temp1);
//        ListNode.printListNodes(listNode1);
//        ListNode listNode2 = oddEvenList(temp2);
//        ListNode.printListNodes(listNode2);
        ListNode listNode3 = oddEvenList(temp3);
        ListNode.printListNodes(listNode3);
        ListNode listNode4 = oddEvenList(temp4);
        ListNode.printListNodes(listNode4);
        ListNode listNode5 = oddEvenList(temp5);
        ListNode.printListNodes(listNode5);
        ListNode listNode6 = oddEvenList(temp6);
        ListNode.printListNodes(listNode6);
    }

    public ListNode oddEvenList(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) {//如果长度小于等于2的话表明原样输出
            return head;
        }
        ListNode tail = head;
        int count = 0;
        while (true) {//查找尾节点
            count++;
            if (null != tail.next) {
                tail = tail.next;
            } else {
                break;
            }
        }

        ListNode currentNode = head,
                before = null;
        for (int index = 1; index <= count; index++) {
            if(null == before){
                before = currentNode;
                continue;
            }
            currentNode = before.next;
            if (index % 2 == 1) {
                before = currentNode;
            }
            if (index % 2 == 0) {//偶数
                //偶数后面还有数字，则直接添加到tail后面，将前和尾连接起来
                before.next = currentNode.next;//连接两个奇数的点
                ListNode next = currentNode.next;

                //将偶数点放到尾部
                tail.next = currentNode;
                tail = currentNode;
                tail.next = null;
            }
        }

        return head;
    }

    /**
     * 官方最佳答案
     */
    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = head.next;
        while(true){
            if(even.next != null) {
                odd.next = even.next;
                odd = odd.next;
            }
            else {
                odd.next = null;
                break;
            }
            if(even.next.next != null) {
                even.next = even.next.next;
                even = even.next;
            }
            else {
                even.next = null;
                break;
            }
        }
        odd.next = evenHead;
        return head;
    }
}
