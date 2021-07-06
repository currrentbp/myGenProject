package com.currentbp.common.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baopan
 * @createTime 20191206
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(List<Integer> list) {
        doList(list);
    }

    public TreeNode(Integer[] arr) {
        List<Integer> result = new ArrayList<>(Arrays.asList(arr));
        doList(result);
    }

    private void doList(List<Integer> list) {
    /*
    [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
         */
        if (null == list || 0 == list.size()) {
            return;
        }

        List<TreeNode> listNode = new ArrayList<>();
        listNode.add(this);

        for (int i = 0, cursor = 1; i < list.size(); i++) {
            TreeNode currentNode = listNode.get(i);//当前节点
            Integer currentValue = list.get(i);//当前节点的值

            if (null != currentValue) {
                currentNode.val = currentValue;

                TreeNode left = null, right = null;
                if (cursor < list.size() && null != list.get(cursor)) {//左节点，如果左节点不存在，则不需要初始化
                    left = new TreeNode(list.get(cursor));
                    currentNode.left = left;
                    listNode.add(left);
                } else {
                    listNode.add(null);
                }
                if (cursor + 1 < list.size() && null != list.get(cursor + 1)) {//右节点，如果右节点不存在，则不需要初始化
                    right = new TreeNode(list.get(cursor + 1));
                    currentNode.right = right;
                    listNode.add(right);
                } else {
                    listNode.add(null);
                }
                cursor = cursor + 2;//表示下一个节点的左右子节点的左节点的位置
            } else {//当前值为null表示这个节点为空
                continue;
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
