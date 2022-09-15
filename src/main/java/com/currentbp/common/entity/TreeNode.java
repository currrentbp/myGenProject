package com.currentbp.common.entity;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;

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
    3.1、最低层l0的数字间隔为1，倒数第二层l1的数字间隔为
     */
    public void print() {
        int dept = getMaxDept(this);
        List<List<TreeNode>> fullTreeList = getFullTreeList(this, dept);
        doPrint(fullTreeList);
    }

    private void doPrint(List<List<TreeNode>> fullTreeList) {
        if (null == fullTreeList || 0 == fullTreeList.size()) {
            return;
        }

        List<TreeNode> downTreeNodes = fullTreeList.get(fullTreeList.size() - 1);
        int maxSize = downTreeNodes.size();
        List<List<String>> result = new ArrayList<>();
        List<String> temp1 = getDefaultList(maxSize);
        for (int i = 0; i < downTreeNodes.size(); i++) {
            temp1.set(i * 2, "" + (downTreeNodes.get(i) == null ? "" : downTreeNodes.get(i).val));
        }
        result.add(temp1);

        for (int i = 0; i < result.size(); i++) {
            List<String> current = result.get(i);
            int index = fullTreeList.size() - 2 - i;
            if (index < 0) {
                break;
            }
            List<TreeNode> topTreeNodes = fullTreeList.get(index);

            List<String> temp = getDefaultList(maxSize);
            int first = 0;
            int second = 0;
            int topIndex = 0;
            for (int j = 0; j < temp.size(); j++) {
                if (!current.get(j).equals("#")) {
                    first = j;
                } else {
                    continue;
                }
                for (int k = j + 1; k < temp.size(); k++) {
                    if (!current.get(k).equals("#")) {
                        second = k;
                        break;
                    }
                }
                int middle = (first + second) / 2;
                temp.set(middle, "" + (topTreeNodes.get(topIndex) == null ? "" : topTreeNodes.get(topIndex).val));
                topIndex++;
                j = second;
            }
            result.add(temp);
        }

//        for (int i = result.size() - 1; i >= 0; i--) {
//            StringUtil.printObject(result.get(i));
//        }

        for (int i = result.size() - 1; i >= 0; i--) {
            List<String> line = result.get(i);
            for (int j = 0; j < line.size(); j++) {
                if(line.get(j).equals("#")){
                    System.out.print("  ");
                }else if(line.get(j).equals("")){
                    System.out.print("  ");
                }else {
                    System.out.print(line.get(j));
                }
            }
            System.out.println();
        }
    }


    private List<List<TreeNode>> getFullTreeList(TreeNode treeNode, int dept) {
        if (null == treeNode) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> result = new ArrayList<>();
        result.add(Lists.newArrayList(treeNode));
        for (int i = 0; i < dept; i++) {
            List<TreeNode> temp = new ArrayList<>();
            List<TreeNode> treeNodes = result.get(i);
            for (TreeNode node : treeNodes) {
                if (null == node) {
                    temp.add(null);
                    temp.add(null);
                } else {
                    temp.add(node.left);
                    temp.add(node.right);
                }
            }
            result.add(temp);
        }

        return result;
    }

    private int getMaxDept(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int max = 1;
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

    private List<String> getDefaultList(int maxSize) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < maxSize * 2 - 1; i++) {
            temp.add("#");
        }
        return temp;
    }

}
