package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import javafx.util.Pair;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 5/3/2023 8:54 PM
 */
public class T0662widthOfBinaryTree {
    /*
给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
树的 最大宽度 是所有层中最大的 宽度 。
每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，
两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
题目数据保证答案将会在  32 位 带符号整数范围内。
示例 1：
输入：root = [1,3,2,5,3,null,9]
输出：4
解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
示例 2：
输入：root = [1,3,2,5,null,null,9,6,null,7]
输出：7
解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
示例 3：
输入：root = [1,3,2,5]
输出：2
解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
解题思路：
1、暴力计算：将每层的节点全部添加到一个列表中，然后计算每层的宽度
2、每一层都记录所有元素，每个元素除了记录treenode以外还有这个节点的位置
     */
    @Test
    public void t1() {
        System.out.println(widthOfBinaryTree(new TreeNode(Lists.newArrayList(1, 3, 2, 5, 3, null, 9))));//4
        System.out.println(widthOfBinaryTree(new TreeNode(Lists.newArrayList(1, 3, 2, 5, null, null, 9, 6, null, 7))));//7
        System.out.println(widthOfBinaryTree(new TreeNode(Lists.newArrayList(1, 3, 2, 5))));//2
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Pair<TreeNode, Integer>> levels = new ArrayList<>();
        List<Pair<TreeNode, Integer>> temps = new ArrayList<>();
        levels.add(new Pair<>(root, 0));

        int max = 0;
        while (true) {
            if (levels.size() == 0) {
                break;
            }
            max = Math.max(max, levels.get(levels.size() - 1).getValue() - levels.get(0).getValue() + 1);

            for (int i = 0; i < levels.size(); i++) {
                Pair<TreeNode, Integer> node = levels.get(i);
                TreeNode key = node.getKey();
                if (key.left != null) {
                    temps.add(new Pair<>(key.left, node.getValue() * 2));
                }
                if (key.right != null) {
                    temps.add(new Pair<>(key.right, node.getValue() * 2 + 1));
                }
            }

            levels = temps;
            temps = new ArrayList<>();

        }

        return max;
    }

    /*
    内存超过了
     */
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> levels = new ArrayList<>();
        List<TreeNode> temps = new ArrayList<>();
        levels.add(root);

        int max = 0;
        while (true) {
            int width = getWidth(levels);
            if (width == 0) {
                break;
            }
            max = Math.max(max, width);

            for (int i = 0; i < levels.size(); i++) {
                TreeNode currentNode = levels.get(i);
                if (currentNode == null) {
                    temps.add(null);
                    temps.add(null);
                } else {
                    temps.add(currentNode.left);
                    temps.add(currentNode.right);
                }
            }
            levels = temps;
            temps = new ArrayList<>();
        }

        return max;
    }

    private int getWidth(List<TreeNode> levels) {
        if (levels == null || levels.size() == 0) {
            return 0;
        }

        int left = 0, right = levels.size() - 1;
        while (left < right) {
            boolean isDo = false;
            if (levels.get(left) == null) {
                left++;
                isDo = true;
            }
            if (levels.get(right) == null) {
                right--;
                isDo = true;
            }
            if (!isDo) {
                break;
            }
        }
        return right - left + 1;
    }
}
