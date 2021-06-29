package com.currentbp.Interesting.likou.offer;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

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
    public void t1(){
//        TreeNode A = new TreeNode(Lists.newArrayList(1, 2, 3));
//        TreeNode B = new TreeNode(Lists.newArrayList(3, 1));
        TreeNode A = new TreeNode(Lists.newArrayList(3,4,5,1,2));
        TreeNode B = new TreeNode(Lists.newArrayList(4,1));
        StringUtil.printObject(isSubStructure(A,B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (A.val == B.val) {
            return isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right);
        }
        return false;
    }
}
