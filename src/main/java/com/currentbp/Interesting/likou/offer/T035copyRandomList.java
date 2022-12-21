package com.currentbp.Interesting.likou.offer;

import com.currentbp.common.entity.Node;

/**
 * @author baopan
 * @createTime 20221220
 */
public class T035copyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node result = new Node(0);
        Node before = result;
        Node temp = head;
        while(temp != null){
            Node node1 = new Node(temp.val);
            before.next=node1;
            before = node1;
        }

        Node copyNode = result.next;


    }
}
