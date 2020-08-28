package com.currentbp.Interesting.other;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/26 17:31
 */
public class FindError {

    /*
    一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
    使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值。
    (每个节点的值各不相同)
     */

    @Test
    public void t1() {
        TreeNode root = new TreeNode(Lists.newArrayList(1, 2, 3));
        int[] error = findError2(root);
        StringUtil.printObject(error);

        TreeNode root2 = new TreeNode(Lists.newArrayList(1,2,6,4,3,5,7));
        int[] error2 = findError2(root2);
        StringUtil.printObject(error2);
    }


    /*
    网上的答案
     */
    private int[] findError2(TreeNode root) {
        // write code here
        int[] res = new int[2];
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode point = null;//栈顶弹出的元素，是用来比较的第一个元素
        while (!queue.isEmpty() || cur != null) {
            if (cur != null) {
                queue.addLast(cur);
                cur = cur.left;
            } else {
                cur = queue.pollLast();
                if (point != null && point.val > cur.val) {
                    res[1] = res[1] == 0 ? point.val : res[1];
                    res[0] = cur.val;
                }
                point = cur;
                cur = cur.right;
            }
        }
        return res;

    }

    private int[] findError(TreeNode root) {
        int[] res = new int[2];
        List<TreeNode> sources = new ArrayList<>();
        beforeSort(root, sources);

        getError(sources, res);
        return res;

    }

    private void getError(List<TreeNode> sources, int[] res) {
        if (null == sources || 0 == sources.size()) {
            return;
        }
        int left = 0, right = sources.size() - 1;
        boolean leftFlag = false;

        boolean rightFlag = false;
        while (left < right) {
            if (leftFlag && rightFlag) {
                break;
            }
            if(!leftFlag) {
                if (sources.get(left).val > sources.get(left + 1).val) {
                    res[0] = sources.get(left).val;
                    leftFlag = true;
                } else {
                    left++;
                }
            }

            if(!rightFlag) {
                if (sources.get(right).val < sources.get(right - 1).val) {
                    res[1] = sources.get(right).val;
                    rightFlag = true;
                } else {
                    right--;
                }
            }
        }
    }

    private void beforeSort(TreeNode root, List<TreeNode> sources) {
        if (null == root) {
            return;
        }

        if (root.left != null) {
            beforeSort(root.left, sources);
        }
        sources.add(root);
        if (null != root.right) {
            beforeSort(root.right, sources);
        }
    }
}
