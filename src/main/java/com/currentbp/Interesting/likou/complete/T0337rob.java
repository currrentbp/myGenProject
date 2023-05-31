package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/5/28 0:01
 */
public class T0337rob {
    /*
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。

除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
示例 1:
输入: root = [3,2,3,null,3,null,1]
输出: 7
解释:小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
示例 2:
输入: root = [3,4,5,1,3,null,1]
输出: 9
解释:小偷一晚能够盗取的最高金额 4 + 5 = 9

解题思路：
1、一个节点可以被打劫也可以不被打劫，那么就有两种情况，当前节点被不被打劫的能抢到最多的钱是多少
     */

    @Test
    public void t1() {
        StringUtil.printObject(rob(new TreeNode(Lists.newArrayList(3, 2, 3, null, 3, null, 1))));
        StringUtil.printObject(rob(new TreeNode(Lists.newArrayList(3, 4, 5, 1, 3, null, 1))));
    }

    //当前节点不被抢能抢到最多的钱
    Map<TreeNode, Integer> noRob2CountMap = new HashMap<>();
    //当前节点被抢能抢最多的钱
    Map<TreeNode, Integer> rob2CountMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        doRob(root);
        return Math.max(noRob2CountMap.getOrDefault(root, 0), rob2CountMap.getOrDefault(root, 0));
    }

    private void doRob(TreeNode root) {
        if (root == null) {
            return;
        }
        doRob(root.left);
        doRob(root.right);

        //当前节点不被抢，max(l) + max(r) :左节点的max是从抢和不抢求max，右节点的max是从抢和不抢求max
        noRob2CountMap.put(root, Math.max(noRob2CountMap.getOrDefault(root.left, 0), rob2CountMap.getOrDefault(root.left, 0))
                + Math.max(noRob2CountMap.getOrDefault(root.right, 0), rob2CountMap.getOrDefault(root.right, 0)));
        //当前节点被抢，当前+(l)+(r): 当前+ （左节点的不抢的收益）+（右节点的不抢的收益）
        rob2CountMap.put(root, root.val
                + noRob2CountMap.getOrDefault(root.left, 0)
                + noRob2CountMap.getOrDefault(root.right, 0));
    }
}
