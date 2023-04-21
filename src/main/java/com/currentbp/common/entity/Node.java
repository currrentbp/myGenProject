package com.currentbp.common.entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node next;
    public Node left;
    public Node right;
    public Node random;
    public List<Node> neighbors;

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
