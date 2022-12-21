package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 20221220
 */
public class T035copyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node result = new Node(0);
        Node before = result;
        Node temp = head;
        while (temp != null) {
            Node node1 = new Node(temp.val);
            before.next = node1;
            before = node1;

            temp = temp.next;
        }

        Node copyNode = result.next;

        Node indexHead = head;
        Node indexCopyHead = copyNode;

        while (indexHead != null) {
            if (indexHead.random == null) {
                indexHead = indexHead.next;
                indexCopyHead = indexCopyHead.next;
                continue;
            }

            Node random = indexHead.random;

            Node cursorHead = head;
            Node cursorCopyHead = copyNode;
            while (cursorHead != null) {
                if (cursorHead == random) {
                    break;
                } else {
                    cursorHead = cursorHead.next;
                    cursorCopyHead = cursorCopyHead.next;
                }
            }
            indexCopyHead.random = cursorCopyHead;

        }
        return copyNode;
    }


    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node result = new Node(0);
        Node before = result;
        Node temp = head;

        Map<Node,Node> kvs = new HashMap<>();
        while (temp != null) {
            Node node1 = new Node(temp.val);
            before.next = node1;
            before = node1;

            kvs.put(temp,node1);

            temp = temp.next;
        }

        Node copyNode = result.next;

        for (Map.Entry<Node, Node> kv : kvs.entrySet()) {
            Node key = kv.getKey();
            Node value = kv.getValue();

            Node random = key.random;
            if(random == null){
                continue;
            }

            Node node = kvs.get(random);
            value.random = node;
        }

        return copyNode;
    }
}
