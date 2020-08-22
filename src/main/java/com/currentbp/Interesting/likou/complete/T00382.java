package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.Random;

/**
 * @author baopan
 * @createTime 2020/8/9 11:27
 */
public class T00382 {
    /*
给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
进阶:
如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
示例:
// 初始化一个单链表 [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);
// getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
solution.getRandom();

解题思路：
1、蓄水池算法，
     */

    private ListNode head = null;
    public T00382(){}
//    public T00382(ListNode head) {
//        this.head = head;
//    }

    @Test
    public void t1(){
        int random = new Random().nextInt(2);
        StringUtil.printObject(random);
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode currentNode = head;
        int count = 0;
        int[] resolver = new int[1];

        while(null != currentNode){
            count++;
            int random = new Random().nextInt(count);
            if(count == random){
                resolver[0] = currentNode.val;
            }
            currentNode = currentNode.next;
        }

        return resolver[0];
    }
}
