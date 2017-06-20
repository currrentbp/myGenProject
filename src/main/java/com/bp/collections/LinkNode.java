package com.bp.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 链式结构
 *
 * @author current_bp
 * @createTime 20170620
 */
public class LinkNode {
    /*
    本类主要测试两个链表结构的数据，合并成一个链表，这两个链表是有序的
     */

    @Test
    public void test1() {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(5);
        a.add(8);

        List<Integer> b = new ArrayList<Integer>();
        b.add(2);
        b.add(3);
        b.add(7);


        Node nodeA = new Node(a);
        Node nodeB = new Node(b);
        Node nodeC = pasteNodeLink(nodeA, nodeB);
        while (true) {
            if (nodeC == null) {
                break;
            }
            System.out.print("" + nodeC.getValue() + " ");
            nodeC = nodeC.getNext();
        }
    }

    /**
     * 将两个链表连接起来
     *
     * @param nodeA A链表
     * @param nodeB B链表
     * @return 结果链表
     */
    public Node pasteNodeLink(Node nodeA, Node nodeB) {
        if (null == nodeA) {
            return nodeB;
        } else if (null == nodeB) {
            return nodeA;
        }

        //谁第一个数最小，谁就做头，最后都是A做头（做一个互换动作）
        Node nodeAHead = nodeA;
        Node nodeBHead = nodeB;

        //做一个转换头，确保A的头是最小
        if (nodeBHead.getValue() < nodeAHead.getValue()) {
            Node temp = nodeB;
            nodeB = nodeA;
            nodeA = temp;
        }

        Node nodeAIndex = nodeA;
        Node nodeBIndex = nodeB;
        while (true) {
            if (null == nodeAIndex) {
                break;
            }
            Node aNext = nodeAIndex.getNext();

            //将B节点插入A链表中
            while (true) {
                if (nodeBIndex == null) {
                    break;
                }

                if (nodeAIndex.getValue() <= nodeBIndex.getValue() && (null == aNext || nodeBIndex.getValue() <= aNext.getValue())) {
                    //将B的index插入A中
                    Node tempB = new Node();
                    tempB.setValue(nodeBIndex.getValue());
                    nodeAIndex.setNext(tempB);
                    nodeAIndex = tempB;
                    //将下一个节点连起来
                    tempB.setNext(aNext);
                    //设置B的下一个标记位置
                    nodeBIndex = nodeBIndex.getNext();
                } else {
                    break;
                }
            }

            //设置A的下一个标记位置
            nodeAIndex = aNext;


        }

        return nodeAHead;
    }
}

class Node {
    private int value;
    private Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(List<Integer> list) {
        if (null == list || 0 == list.size()) {
        } else {
            value = list.get(0);
            Node index = this;
            //从第二个开始
            if (list.size() >= 2) {
                for (int i = 1; i < list.size(); i++) {
                    Node node = new Node(list.get(i));
                    index.setNext(node);
                    index = node;
                }
            }
        }


    }

    public boolean hasNext() {
        return null != next;
    }

    //=======  get and set  ==========================================================//

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
