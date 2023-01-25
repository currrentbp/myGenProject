package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 1/10/2023 10:17 AM
 */
public class T036treeToDoublyList {
    /*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
为了让您更好地理解问题，以下面的二叉搜索树为例：
我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
     */

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            root.left=root;
            root.right = root;
            return root;
        }
        List<Node> lists = new ArrayList<>();
        doMiddleTree(root, lists);

        return doLink(lists);
    }

    private Node doLink(List<Node> lists) {
        Node first = lists.get(0);
        int i = 1;
        while (i < lists.size()) {
            Node next = lists.get(i);
            first.right = next;
            next.left = first;
            first = next;
            i++;
        }
        lists.get(0).left = lists.get(lists.size() - 1);
        lists.get(lists.size() - 1).right = lists.get(0);
        return lists.get(0);
    }

    private void doMiddleTree(Node root, List<Node> lists) {
        if (root == null) {
            return;
        }
        doMiddleTree(root.left, lists);
        lists.add(root);
        doMiddleTree(root.right, lists);
    }
}
