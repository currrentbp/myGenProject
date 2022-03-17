package com.currentbp.test.sort.t20220316;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220316
 */
public class DichotomyQuery {
    /*
二分法查询
     */
    @Test
    public void t1() {
        System.out.println(queryIndx(new int[]{1, 2}, 3));
    }

    public int queryIndx(int[] arr, int target) {
        int index = -1;
        if (target < arr[0] || arr[arr.length - 1] < target) {
            return index;
        }
        int left = 0, right = arr.length, middle = (left + right) / 2;
        while (left < right) {
            if (arr[middle] == target) {
                index = middle;
                break;
            }
            if (arr[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
            middle = (left + right) / 2;
        }

        return index;
    }
}
