package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author baopan
 * @createTime 20210801
 */
public class T01337KWeakestRows {
    /*
给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
     */
    @Test
    public void t3(){
        System.out.println(new Date());
    }

    @Test
    public void t1() {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        StringUtil.printObject(kWeakestRows(mat, 3));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> values = new ArrayList(mat.length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                values.set(i, values.get(i) + mat[i][j]);
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < values.size(); i++) {


        }

        return new int[k];
    }
}
