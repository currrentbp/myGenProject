package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 判断是否是出入栈顺序
 *
 * @author baopan
 * @createTime 2020/7/21 22:08
 */
public class IsStackOrder {

//TODO notwork
    @Test
    public void t1() {
        int[] a = new int[]{3, 5, 2, 7, 9};
        int[] b = new int[]{5, 3, 9, 2, 7};
        boolean v = isValid(a, b);
        StringUtil.printObject(v);
    }

    @Test
    public void t2() {
        int[] a = new int[]{3, 5, 2, 7, 9};
        int[] b = new int[]{5, 3, 9, 2, 7};
        boolean v = isValid2(a, b);
        StringUtil.printObject(v);
    }

    private boolean isValid2(int[] a, int[] b) {
        if ((null == a && null == b) || (0 == a.length && 0 == b.length)) {
            return true;
        }
        if (a.length != b.length) {
            return false;
        }

        return false;
    }

    private boolean isValid(int[] a, int[] b) {
        if ((null == a && null == b) || (0 == a.length && 0 == b.length)) {
            return true;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            boolean canFind = false;
            for (int j = i; j < b.length; j++) {
                if (a[i] == b[j]) {
                    canFind = true;//找到一样的数字了
                    boolean minStack = isMinStack(a, b, i, j);
                    if (minStack) {
                        i = j;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            if (!canFind) {
                return false;
            }
        }
        return true;
    }

    private boolean isMinStack(int[] a, int[] b, int start, int end) {
        int temp = start;
        while (temp <= end) {
            if (a[start] != b[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
