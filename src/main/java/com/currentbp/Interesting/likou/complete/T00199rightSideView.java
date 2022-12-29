package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221229
 */
public class T00199rightSideView {
    /*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例 1:
输入:[1,2,3,null,5,null,4]
输出:[1,3,4]
示例 2:
输入:[1,null,3]
输出:[1,3]
示例 3:
输入:[]
输出:[]

     */

    public List<Integer> rightSideView(TreeNode root) {
        if(root ==null){
            return new ArrayList<>();
        }

        List<TreeNode> tops = new ArrayList<>();
        List<TreeNode> temps = new ArrayList<>();
        tops.add(root);

        List<Integer> result = new ArrayList<>();
        while(true){
            if(tops.size() == 0){
                break;
            }
            result.add(tops.get(tops.size()-1).val);

            for (TreeNode top : tops) {
                if(top.left != null){
                    temps.add(top.left);
                }
                if(top.right != null){
                    temps.add(top.right);
                }
            }
            tops = temps;
            temps = new ArrayList<>();
        }
        return result;
    }
}
