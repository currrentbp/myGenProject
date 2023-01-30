package com.currentbp.sort.test20230129;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 1/29/2023 11:42 AM
 */
public class KuaiPai0129 {
    /*
    快排：从小到大
解题思路：
方程：y|f(x) = f(left)+y+f(right);
            1、从right开始向左找一个比y小的a,从left开始向右找一个比y大的b
            2、交换a和b
            3、继续1操作和2操作，直到left和right相遇，跳出当前循环
            4、交换基准y和相遇的数字
            5、对y左边的区间和y右边的区间再次做1-4操作

     */

    @Test
    public void t1() {
        int[] source = new int[]{1, 2, 10, 5, 3, 4, 7, 6, 9, 8, 2};
        kpSort(source);
        StringUtil.printObject(source);
    }

    private void kpSort(int[] source) {
        if (source == null || source.length <= 1) {
            return;
        }
        int left = 0, right = source.length - 1;

        doKpSort(source, left, right);
    }

    private void doKpSort(int[] source, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left, high = right;
        int y = source[left];
        //将low位置的和high位置的数字交换，直到low和high相遇
        while (low < high) {
            while (low < high && source[high] >= y) {
                high--;
            }
            while (low < high && source[low] <= y) {
                low++;
            }
            if (low < high)
                swap(source, low, high);
        }
        //交换基准数字
        swap(source, left, low);

        doKpSort(source, left, low - 1);
        doKpSort(source, low + 1, right);
    }

    private void swap(int[] source, int i, int j) {
        if (source[i] < source[j]) {
            return;
        }
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }
}
