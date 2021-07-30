package com.currentbp.Interesting.likou.LCP.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210715
 */
public class T02Fraction {
    /*
有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
示例 1：
输入：cont = [3, 2, 0, 2]
输出：[13, 4]
解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
示例 2：
输入：cont = [0, 0, 3]
输出：[3, 1]
解释：如果答案是整数，令分母为1即可。
     */

    @Test
    public void t1() {
        StringUtil.printObject(fraction(new int[]{0, 0, 3}));
    }

    public int[] fraction(int[] cont) {
        int[] result = new int[]{1, 1};
        if (cont.length == 1) {
            result[0] = cont[0];
            return result;
        }

        int son = 1, mother = cont[cont.length - 1];
        for (int index = cont.length - 2; index >= 0; index--) {
            son = son + mother * cont[index];
            int temp = son;
            son = mother;
            mother = temp;
        }
        result[0] = mother;
        result[1] = son;

        result = simple(result);

        return result;
    }

    private int[] simple(int[] result) {
        int min = result[0] > result[1] ? result[1] : result[0];
        if (result[0] % min == 0 && result[1] % min == 0) {
            return new int[]{result[0] / min, result[1] / min};
        }

        int middle = (int) Math.sqrt(min)+1;
        while (true) {
            if (middle == 1) {
                break;
            }
            if (result[0] % middle == 0 && result[1] % middle == 0) {
                result[0] = result[0] / middle;
                result[1] = result[1] / middle;
                continue;
            }
            middle--;
        }

        return result;
    }

    @Test
    public void t2(){
        System.out.println((int)Math.sqrt(12));
        StringUtil.printObject(simple(new int[]{12,50}));
    }
}
