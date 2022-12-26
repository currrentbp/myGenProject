package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221226
 */
public class T032levelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> floor = new ArrayList<>();
        floor.add(root);

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> nextFloor = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < floor.size(); i++) {
            temp.add(floor.get(i).val);
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
                i = -1;
                if (floor.size() <= 0) {
                    break;
                }
            }
        }

        return result;
    }
}
