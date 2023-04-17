package com.currentbp.common.entity;


import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/12 21:08
 */
public class LinkNode {
    public int value;
    public LinkNode next;

    public LinkNode() {
    }

    public LinkNode(int value) {
        this.value = value;
    }

    public LinkNode(List<Integer> list) {
        if (null == list || 0 == list.size()) {
            throw new RuntimeException("need more than one element");
        } else {
            value = list.get(0);
            LinkNode index = this;
            //从第二个开始
            if (list.size() >= 2) {
                for (int i = 1; i < list.size(); i++) {
                    LinkNode node = new LinkNode(list.get(i));
                    index.next = node;
                    index = node;
                }
            }
        }
    }

    public LinkNode(int[] list) {
        if (null == list || 0 == list.length) {
            throw new RuntimeException("need more than one element");
        } else {
            value = list[0];
            LinkNode index = this;
            //从第二个开始
            if (list.length >= 2) {
                for (int i = 1; i < list.length; i++) {
                    LinkNode node = new LinkNode(list[i]);
                    index.next = node;
                    index = node;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LinkNode head = this;
        while (head != null) {
            stringBuilder.append("" + head.value + "->");
            head = head.next;
        }
        stringBuilder.append("end");

        return stringBuilder.toString();
    }
}
