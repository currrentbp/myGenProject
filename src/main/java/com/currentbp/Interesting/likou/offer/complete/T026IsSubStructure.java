package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20210627
 */
public class T026IsSubStructure {
    /*
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。
例如:
给定的树 A:
   3
  / \
 4  5
 / \
1  2
给定的树 B：
 4
 /
1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
示例 1：
输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
     */

    @Test
    public void t1() {
        TreeNode A = new TreeNode(Lists.newArrayList(1, 2, 3));
        TreeNode B = new TreeNode(Lists.newArrayList(3, 1));
//        TreeNode A = new TreeNode(Lists.newArrayList(3, 4, 5, 1, 2));
//        TreeNode B = new TreeNode(Lists.newArrayList(4, 1));
        StringUtil.printObject(isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == B && null ==A) {
            return true;
        }
        if (null == A || null == B) {
            return false;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(A);
        for (int i = 0; i < list.size(); i++) {
            if (null != list.get(i).left) {
                list.add(list.get(i).left);
            }
            if (null != list.get(i).right) {
                list.add(list.get(i).right);
            }

            if (list.get(i).val == B.val) {
                if (theSameDoEach(list.get(i), B)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean theSameDoEach(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (null == A) {
            return false;
        }
        if (A.val == B.val) {
            return theSameDoEach(A.left, B.left) && theSameDoEach(A.right, B.right);
        }

        return false;
    }


    /**
     * 官方最佳答案
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if(A==null || B ==null){
            return false;
        }
        return isTree(A,B) || isSubStructure2(A.left,B) || isSubStructure2(A.right,B);
    }

    public boolean isTree(TreeNode A,TreeNode B){
        if(B == null){
            return true;
        }
        if(A ==null || A.val!=B.val){
            return false;
        }
        return isTree(A.left,B.left) && isTree(A.right,B.right);
    }
}
