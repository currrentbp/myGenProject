package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 1/10/2023 10:44 AM
 */
public class T054kthLargest {

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        doLast(root, list);
        return list.size() >= k ? list.get(list.size() - k) : -1;
    }

    private void doLast(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        doLast(root.left, list);
        list.add(root.val);
        doLast(root.right, list);
    }
}
