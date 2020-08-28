package com.currentbp.Interesting.other;

import com.currentbp.common.entity.ListNode;
import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/8/24 21:01
 */
public class TreeMaxLevel {

    @Test
    public void t1(){
        List<Integer> r = Lists.newArrayList(3, 9, 20, null, 3, 15, 7);
        TreeNode treeNode = new TreeNode(r);
        int max = getMax(treeNode);
        StringUtil.printObject(max);
    }

    public int getMax(TreeNode root){
        if(null == root)return 0;
        List<TreeNode> currentC = new ArrayList<>();
        currentC.add(root);
        int max = 1;

        List<TreeNode> temp;
        while(true){
            temp = new ArrayList<>();
            for(int i=0;i<currentC.size();i++){
                if(null != currentC.get(i).left)
                    temp.add(currentC.get(i).left);
                if(null != currentC.get(i).right)
                    temp.add(currentC.get(i).right);
            }
            currentC = temp;
            max = Math.max(max,currentC.size());
            if(currentC.size() ==0 ){
                break;
            }
        }
        return max;
    }
}
