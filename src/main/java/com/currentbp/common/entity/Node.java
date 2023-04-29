package com.currentbp.common.entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node next;
    public Node prev;
    public Node left;
    public Node right;
    public Node random;
    public Node down;
    public Node child;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public static Node createNode4Random(Integer[][] sources) {
        if (sources == null || sources.length == 0) {
            return null;
        }

        List<Node> lists = new ArrayList<>();

        for (int i = 0; i < sources.length; i++) {
            Integer[] source = sources[i];
            Node temp = new Node(source[0]);
            lists.add(temp);
        }
        Node before = new Node(0);
        //设置next
        for (int i = 0; i < sources.length; i++) {
            before.next = lists.get(i);
            before = before.next;
        }
        //设置random
        for (int i = 0; i < sources.length; i++) {
            Integer randomIndex = sources[i][1];
            if (randomIndex != null) {
                lists.get(i).random = lists.get(randomIndex);
            }
        }

        return lists.get(0);
    }

    public static Node createNode4Child(Integer[] sources) {
        if (sources == null || sources.length == 0) {
            return null;
        }
        /*
        [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
        1-->2-->3-->4-->5-->6
                7-->8-->9-->10
                    11->12

        1,null,2,null,3,null
        1-->end
        2-->end
        3-->end
         */

        Node node = new Node(0), head = node;
        //顶层
        int index = 0;
        for (; index < sources.length; index++) {
            if (sources[index] == null) {
                break;
            }
            head.next = new Node(sources[index]);
            head.next.prev = head;
            head = head.next;
        }

        doChild(node.next, sources, index);

        node.next.prev = null;
        return node.next;
    }

    private static void doChild(Node node, Integer[] sources, int index) {
        if (index >= sources.length) {
            return;
        }
        Node childHead = new Node(0), head = childHead;
        Node parent = node;

        for (index = index + 1; index < sources.length; index++) {
            if (sources[index] == null) {
                parent = parent.next;
            } else {
                break;
            }
        }

        for (; index < sources.length; index++) {
            if (sources[index] != null) {
                head.next = new Node(sources[index]);
                head.next.prev = head;
                head = head.next;
            } else {
                break;
            }
        }

        parent.child = childHead.next;
        childHead.next.prev = null;

        doChild(parent.child, sources, index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node head = this;
        while (head != null) {
            sb.append("" + head.val + " ->");
            head = head.next;
        }
        sb.append("end");
        return sb.toString();
    }
}
