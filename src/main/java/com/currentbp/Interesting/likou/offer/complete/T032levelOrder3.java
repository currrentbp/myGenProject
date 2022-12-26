package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221226
 */
public class T032levelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> floor = new ArrayList<>();
        floor.add(root);

        List<TreeNode> nextFloor = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < floor.size(); i++) {
            if (flag) {
                temp.add(floor.get(i).val);
            } else {
                temp.add(0, floor.get(i).val);
            }
            if (floor.get(i).left != null) {
                nextFloor.add(floor.get(i).left);
            }
            if (floor.get(i).right != null) {
                nextFloor.add(floor.get(i).right);
            }

            if (i == floor.size() - 1) {
                result.add(temp);
                temp = new ArrayList<>();
                floor = nextFloor;
                nextFloor = new ArrayList<>();
                flag = !flag;
                i = -1;
                if (floor.size() <= 0) {
                    break;
                }
            }
        }

        return result;
    }
}
