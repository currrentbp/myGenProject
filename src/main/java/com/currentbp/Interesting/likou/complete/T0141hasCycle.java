package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2023/4/20 23:15
 */
public class T0141hasCycle {
    /*
给你一个链表的头节点 head ，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
示例2：
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。

     */
    @Test
    public void t1(){

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> exists = new HashSet<>();

        while(head != null){
            if(exists.contains(head)){
                return true;
            }
            exists.add(head);
            head = head.next;
        }
        return false;
    }
}
