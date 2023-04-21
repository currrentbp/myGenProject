package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/7/22 10:31
 */
public class T0118 {
    /*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
     */

    @Test
    public void t1() {
        List<List<Integer>> generate = generate(5);
        StringUtil.printObject(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        for (int i = 0; i < numRows; i++) {//每层列表
            List<Integer> t1 = new ArrayList<>();
            if (0 == i) {//第1层
                t1.add(1);
                result.add(t1);
                continue;
            }
            if (1 == i) {//第二层
                t1.add(1);
                t1.add(1);
                result.add(t1);
                continue;
            }
            List<Integer> befores = result.get(i - 1);
            for (int j = 0; j < i+1; j++) {//遍历上一层获取当前层
                if(0 == j){
                    t1.add(1);
                    continue;
                }
                if(j == i){
                    t1.add(1);
                    continue;
                }
                int sum = befores.get(j - 1) + befores.get(j);
                t1.add(sum);
            }
            result.add(t1);
        }
        return result;
    }
}
