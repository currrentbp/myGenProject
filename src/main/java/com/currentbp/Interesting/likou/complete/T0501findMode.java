package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.*;

/**
 * @author baopan
 * @createTime 2023-06-17 10:55:08
 */
public class T0501findMode {
    /*
给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。
假定 BST 满足如下定义：
结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树
示例 1：
输入：root = [1,null,2,2]
输出：[2]
示例 2：
输入：root = [0]
输出：[0]

     */

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> num2CountMap = new HashMap<>();
        init(num2CountMap, root);

        Map<Integer, List<Integer>> count2NumsMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> entries = num2CountMap.entrySet();
        for (Map.Entry<Integer, Integer> next : entries) {
            Integer num = next.getKey();
            Integer count = next.getValue();
            List<Integer> nums = count2NumsMap.getOrDefault(count, new ArrayList<>());
            nums.add(num);
            count2NumsMap.put(count, nums);
            max = Math.max(max, count);
        }
        List<Integer> list = count2NumsMap.get(max);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void init(Map<Integer, Integer> num2CountMap, TreeNode root) {
        if (root == null) {
            return;
        }

        Integer count = num2CountMap.getOrDefault(root.val, 0);
        num2CountMap.put(root.val, count + 1);
        init(num2CountMap, root.left);
        init(num2CountMap, root.right);
    }
}
