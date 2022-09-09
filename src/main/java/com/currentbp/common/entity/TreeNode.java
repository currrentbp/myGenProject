package com.currentbp.common.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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

    /*
    分析：先生成一个全二叉树，然后再使用空白替换
    1、遍历的出最大深度
    2、获取全二叉树，
    3、根据全二叉树计算出各自的位置并打印出
     */
    public void print() {
        int dept = getMaxDept(this);
        List<List<TreeNode>> fullTreeList = getFullTreeList(this,dept);
        doPrint(fullTreeList);
    }

    private void doPrint(List<List<TreeNode>> fullTreeList) {
        if(null == fullTreeList || 0 == fullTreeList.size()){
            return;
        }


    }

    private List<List<TreeNode>> getFullTreeList(TreeNode treeNode,int dept){
        if(null == treeNode){
            return new ArrayList<>();
        }
        List<List<TreeNode>> result = new ArrayList<>();

        return result;
    }

    private int getMaxDept(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int max = 0;
        List<TreeNode> currentList = new ArrayList<>();
        currentList.add(treeNode);

        for (int i = 0; i < currentList.size(); i++) {
            List<TreeNode> temps = new ArrayList<>();
            if (null != currentList.get(i).left) {
                temps.add(currentList.get(i).left);
            }
            if (null != currentList.get(i).right) {
                temps.add(currentList.get(i).right);
            }

            max++;
            currentList = temps;
        }

        return max;
    }
}
