package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/4/20 22:44
 */
public class T0138copyRandomList {
    /*
给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
返回复制链表的头节点。
用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
val：一个表示Node.val的整数。
random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
你的代码 只 接受原链表的头节点 head 作为传入参数。
示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
解题思路：
1、将链表拆解到一个列表中，并且深拷贝一个新的列表，但是random没有任何指向
2、将列表list转换成一个map
3、将random指向赋值
     */

    @Test
    public void t1() {
        System.out.println(copyRandomList(Node.createNode4Random(new Integer [][]   {{7,null},{13,0},{11,4},{10,2},{1,0}})));
        System.out.println(copyRandomList(Node.createNode4Random(new Integer [][]   {{1,1},{2,1}})));
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        List<Node> originals = new ArrayList<>();
        List<Node> news = new ArrayList<>();
        Map<Node, Integer> original2IndexMap = new HashMap<>();

        int index = 0;
        while (head != null) {
            originals.add(head);
            news.add(new Node(head.val));
            original2IndexMap.put(head, index);

            head = head.next;
            index++;
        }

        Node before = new Node(0);
        for (int i = 0; i < news.size(); i++) {
            Node original = originals.get(i);
            Node random = original.random;
            if (random != null) {
                Integer idx = original2IndexMap.get(random);
                if (idx != null) {
                    news.get(i).random = news.get(idx);
                }
            }

            before.next = news.get(i);
            before = before.next;
        }

        return news.get(0);
    }
}
