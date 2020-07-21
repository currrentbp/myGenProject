package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.ListUtil;
import com.currentbp.util.all.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author baopan
 * @createTime 2020/7/19 21:34
 */
public class T00103 {
    /*
    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]

问题分析：
1、奇数行是顺序的获取数据，偶数行是逆序获取数据
2、根据奇偶性使用列表和栈
3、奇数行使用队列，偶数行使用栈
     */

    @Test
    public void t1() {
        List<Integer> list = ListUtil.newArrayList(3, 9, 20, null, null, 15, 7);
        TreeNode root = new TreeNode(list);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        StringUtil.printObject(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        int index = 1;//行号
        List<TreeNode> odd = new ArrayList<>();//奇数行
        odd.add(root);
        Stack<TreeNode> even = new Stack<>();//偶数行

        //只要有数就循环获取下一层的数据
        while (0 != odd.size() || 0 != even.size()) {
            //1、奇数行是顺序的获取数据，偶数行是逆序获取数据
            //2、根据奇偶性使用列表和栈
            //3、奇数行使用队列，偶数行使用栈
            List<Integer> temp = new ArrayList<>();
            if (index % 2 == 0) {//偶数行
                odd = new ArrayList<>(even.size() * 2);
                List<TreeNode> tempList = new ArrayList<>(even.size() * 2);
                while (!even.empty()) {
                    TreeNode treeNode = even.pop();
                    temp.add(treeNode.val);

                    tempList.add(0, treeNode);
                }
                for (TreeNode treeNode : tempList) {
                    TreeNode left = treeNode.left;
                    if (null != left) {
                        odd.add(left);
                    }
                    TreeNode right = treeNode.right;
                    if (null != right) {
                        odd.add(right);
                    }
                }
                even = new Stack<>();
            } else {//奇数行
                even = new Stack<>();
                for (TreeNode treeNode : odd) {
                    temp.add(treeNode.val);

                    //从左到右以此插入栈中
                    TreeNode left = treeNode.left;
                    if (null != left) {
                        even.push(left);
                    }
                    TreeNode right = treeNode.right;
                    if (null != right) {
                        even.push(right);
                    }
                }
                odd = new ArrayList<>();
            }
            if (null != temp && 0 != temp.size()) {
                result.add(temp);
            }
            index++;
        }

        return result;
    }


    /**
     * 官方最佳答案
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        int depth = 1;
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        list1.add(root);
        while (list1.size() > 0) {
            List<Integer> t = new ArrayList<>();
            for (int i = list1.size() - 1; i >= 0; i--) {
                TreeNode node = list1.get(i);
                t.add(node.val);
                if (depth % 2 == 1) {
                    if (node.left != null) {
                        list2.add(node.left);
                    }
                    if (node.right != null) {
                        list2.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        list2.add(node.right);
                    }
                    if (node.left != null) {
                        list2.add(node.left);
                    }
                }
            }
            result.add(t);
            list1 = list2;
            list2 = new ArrayList<>();
            depth++;
        }
        return result;
    }

}
