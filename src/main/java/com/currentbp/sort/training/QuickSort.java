package com.currentbp.sort.training;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 快速排序
 *
 * @author current_bp
 * @createTime 20180326
 */
public class QuickSort {
    private final static Logger logger = LoggerFactory.getLogger(QuickSort.class);

    public void quickSort(int source[], int low, int high) {
        //todo annotationForTest is not ok
        int left = low;
        int right = high;
        int target = source[low];

        while (left < right) {
            while (left < right && source[right] >= target) {
                right--;
            }
            if (left < right) {
                int temp = source[left];
                source[left++] = source[right];
                source[right] = temp;
            }

            while (left < right && source[left] <= target) {
                left++;
            }
            if (left < right) {
                int temp = source[right];
                source[right--] = source[left];
                source[left] = temp;
            }
        }
        boolean isNotReturn = false;
        for (int index = low, next = index + 1; index < high; index++) {
            if (next < high) {
                if (source[index] > source[next]) {
                    isNotReturn = true;
                    break;
                }
            }
        }
        if (!isNotReturn) {
            return;
        }

        logger.info(JSON.toJSONString(source));
        if (left > low) {
            quickSort(source, low, left - 1);
        }
        if (right < high) {
            quickSort(source, left + 1, high);
        }


    }

    @Test
    public void t1() {
        int arr[] = new int[]{3, 5, 7, 2, 1, 0, 2, 10};
        logger.info(JSON.toJSONString(arr));
        QuickSort quickSort1 = new QuickSort();
        quickSort1.quickSort(arr, 0, arr.length - 1);

        logger.info(JSON.toJSONString(arr));
    }
}
