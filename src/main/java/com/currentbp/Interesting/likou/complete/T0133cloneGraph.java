package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/4/18 21:18
 */
public class T0133cloneGraph {
    /*
给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}
测试用例格式：
简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。

解题思路：
1、遍历所有节点，并且生成所对应的节点，以kv结构存储在map中，key：老节点，value：新节点
2、根据图生成一个新的图
     */

    @Test
    public void t1() {
        String s1 = new String();
        StringBuffer sb = new StringBuffer();
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> old2NewMap = new HashMap<>();
        Map<Node, Boolean> old2FlagMap = new HashMap<>();
        //克隆出新的节点
        doClone(node, old2NewMap, old2FlagMap);
        //根据old图排布出新图
        return doNewMap(node, old2NewMap, old2FlagMap);
    }

    private Node doNewMap(Node node, Map<Node, Node> old2NewMap, Map<Node, Boolean> old2FlagMap) {
        if (node == null) {
            return node;
        }

        doNewMap2(node, old2NewMap, old2FlagMap);
        return old2NewMap.get(node);
    }

    private void doNewMap2(Node node, Map<Node, Node> old2NewMap, Map<Node, Boolean> old2FlagMap) {
        if (node == null) {
            return;
        }
        if (old2FlagMap.get(node)) {
            return;
        }

        old2FlagMap.put(node,true);

        Node newCurrentNode = old2NewMap.get(node);
        List<Node> temp = new ArrayList<>();

        for (Node neighbor : node.neighbors) {
            temp.add(old2NewMap.get(neighbor));
            doNewMap(neighbor, old2NewMap, old2FlagMap);
        }
        newCurrentNode.neighbors = temp;
    }

    private void doClone(Node node, Map<Node, Node> old2NewMap, Map<Node, Boolean> old2FlagMap) {
        if (node == null) {
            return;
        }

        if (old2NewMap.get(node) != null) {
            return;
        } else {
            Node temp = new Node(node.val);
            old2NewMap.put(node, temp);
            old2FlagMap.put(node, false);
        }

        List<Node> neighbors = node.neighbors;
        if (neighbors == null || neighbors.size() == 0) {
            return;
        }

        for (Node neighbor : neighbors) {
            doClone(neighbor, old2NewMap, old2FlagMap);
        }
    }


    /*
    官方解答
     */
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node rn = new Node(node.val, new ArrayList<>());
        visited.put(node, rn);
        for (Node neighbor : node.neighbors) {
            rn.neighbors.add(cloneGraph(neighbor));
        }

        return rn;
    }
}
