package com.currentbp.Interesting.nowcoder;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20191211
 */
public class T001 {
    /*
    在一个二维数组中（每个一维数组的长度相同），
    每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */

    public static String s1 = "s11111";

    @Test
    public void t1() {
        int[][] array = new int[3][2];
        array[0] = new int[]{1,2};
        array[1] = new int[]{2,4};
        array[2] = new int[]{3,5};
        Assert.isTrue(find(3,array),"error");
    }

    @Test
    public void t2(){
        int[][] array = new int[2][4];
        array[0] = new int[]{1,2,8,9};
        array[1] = new int[]{4,7,10,13};
        Assert.isTrue(find(7,array),"error");
    }


    public boolean find(int target, int[][] array) {
        int arrLength = array.length;
        int initLength = array[0].length - 1;
        for (int i = 0; i < arrLength; i++) {
            int[] rows = array[i];
            for (int j = initLength; j >= 0; j--) {
                int localValue = rows[j];
                if (localValue == target) {
                    return true;
                }
                if(localValue<target){
                    break;
                }
                if (localValue > target) {
                    initLength = j - 1;
                }
            }
        }
        return false;
    }
}
