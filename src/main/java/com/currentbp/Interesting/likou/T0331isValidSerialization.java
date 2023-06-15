package com.currentbp.Interesting.likou;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023-06-11 08:41:50
 */
public class T0331isValidSerialization {
    /*
序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
你可以认为输入格式总是有效的
例如它永远不会包含两个连续的逗号，比如"1,,3" 。
注意：不允许重建树。
示例 1:
输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
输出: true
示例2:
输入: preorder = "1,#"
输出: false
示例 3:
输入: preorder = "9,#,#,1"
输出: false
解题思路：
1、判断是否是一棵树，左右子节点必须是#结束，或者一个节点只有左、右的一个节点是#结束
     */
    @Test
    public void t1() {
        /*
        9
      3     2
    4   1       6
         */
//        StringUtil.printObject(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(builder2("9,3,4,#,#,1,#,#,2,#,6,#,#,1"));
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        if (preorder.charAt(0) == '#') {
            return false;
        }
        index = 0;
        root = new TreeNode(Integer.parseInt("" + preorder.charAt(0)));
        return builder(preorder, 0);
    }

    int index = 0;
    TreeNode root = null;

    private boolean builder(String preorder, int index) {


        return false;
    }

    private boolean builder2(String preorder){
        try {
            TreeNode treeNode = builder2(preorder.split(","));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    private TreeNode builder2(String[] preorder) {
        if(index == preorder.length-1){
            if(!preorder[index].equals("#")){
                throw new RuntimeException("1111");
            }
        }
        if (index >= preorder.length) {
            return null;
        }

        if (preorder[index].equals("#")) {
            return null;
        }

        TreeNode top = new TreeNode(Integer.parseInt(preorder[index]));
        index++;
        top.left = builder2(preorder);
        index++;
        top.right = builder2(preorder);
        return top;
    }
}
