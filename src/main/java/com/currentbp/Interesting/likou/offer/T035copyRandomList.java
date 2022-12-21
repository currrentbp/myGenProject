package com.currentbp.Interesting.likou.offer;

import com.currentbp.common.entity.Node;

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
}
