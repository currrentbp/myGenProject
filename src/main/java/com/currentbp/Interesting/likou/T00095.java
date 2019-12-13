package com.currentbp.Interesting.likou;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20191206
 */
public class T00095 {

    @Test
    public void t1(){
        List<TreeNode> treeNodes = generateTrees(2);
        ListUtil.printList(treeNodes);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if(n<=0){
            return treeNodes;
        }
        treeNodes = commonGenTrees(1,n);
        return treeNodes;
    }

    private List<TreeNode> commonGenTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left = commonGenTrees(start, i - 1);
            List<TreeNode> right = commonGenTrees(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = l;
                    currentNode.right = r;
                    allTrees.add(currentNode);
                }
            }
        }
        return allTrees;
    }


    public LinkedList<TreeNode> generateTrees2(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> leftTrees = generateTrees2(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> rightTrees = generateTrees2(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees2(1, n);
    }
}
