package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220923
 */
public class T00100isSameTree {

    /*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
示例 1
输入：p = [1,2,3], q = [1,2,3]
输出：true
示例 2：
输入：p = [1,2], q = [1,null,2]
输出：false
示例 3：
输入：p = [1,2,1], q = [1,1,2]
输出：false
提示
两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104
     */
    /*
解题思路：
1、将其转成层序就可以直接对比两个数组了
     */

    @Test
    public void t1() {
        System.out.println(isSameTree(new TreeNode(Lists.newArrayList(1, 2, 3)), new TreeNode(Lists.newArrayList(1, 2, 3))));
        System.out.println(isSameTree(new TreeNode(Lists.newArrayList(1, 2)), new TreeNode(Lists.newArrayList(1, null, 2))));
        System.out.println(isSameTree(new TreeNode(Lists.newArrayList(1, 2, 1)), new TreeNode(Lists.newArrayList(1, 1, 2))));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        pList.add(p);
        qList.add(q);

        for (int i = 0; i < pList.size(); i++) {
            if (pList.size() != qList.size()) {
                return false;
            }
            TreeNode currentP = pList.get(i);
            TreeNode currentQ = qList.get(i);
            if (null == currentP && null == currentQ) {
                continue;
            }
            if (currentP != null && currentQ != null && currentP.val == currentQ.val) {
                pList.add(currentP.left);
                pList.add(currentP.right);
                qList.add(currentQ.left);
                qList.add(currentQ.right);
            } else {
                return false;
            }
        }
        return true;
    }
}
