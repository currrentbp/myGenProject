package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221226
 */
public class T032levelOrder {

    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<treeNodes.size();i++){
            TreeNode treeNode = treeNodes.get(i);
            result.add(treeNode.val);
            if(treeNode.left != null){
                treeNodes.add(treeNode.left);
            }
            if(treeNode.right != null){
                treeNodes.add(treeNode.right);
            }
        }
        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }
        return temp;
    }
}
