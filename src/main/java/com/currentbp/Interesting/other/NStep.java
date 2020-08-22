package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/18 21:39
 */
public class NStep {
    /**
     * n个台阶，一次只能跳1、2、3次，共有多少中跳法
     * f(n) = f(n-1)+f(n-2)+f(n-3)
     */

    @Test
    public void t1() {
        StringUtil.printObject(getNStep(0));
        StringUtil.printObject(getNStep(1));
        StringUtil.printObject(getNStep(2));
        StringUtil.printObject(getNStep(3));
        StringUtil.printObject(getNStep(4));
        StringUtil.printObject(getNStep(5));
        StringUtil.printObject(getNStep(6));
        StringUtil.printObject(getNStep(7));
        StringUtil.printObject(getNStep(8));
        StringUtil.printObject(getNStep(9));

        StringUtil.printObject(getNStep2(0));
        StringUtil.printObject(getNStep2(1));
        StringUtil.printObject(getNStep2(2));
        StringUtil.printObject(getNStep2(3));
        StringUtil.printObject(getNStep2(4));
        StringUtil.printObject(getNStep2(5));
        StringUtil.printObject(getNStep2(6));
        StringUtil.printObject(getNStep2(7));
        StringUtil.printObject(getNStep2(8));
        StringUtil.printObject(getNStep2(9));
    }

    public int getNStep(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        return getNStep(n - 1) + getNStep(n - 2) + getNStep(n - 3);
    }

    public int getNStep2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int result = 0;
        int first = 1, second = 2, third = 4, index = 4;
        while (index <= n) {
            result = first + second + third;
            first = second;
            second = third;
            third = result;
            index++;
        }

        return result;
    }
}
