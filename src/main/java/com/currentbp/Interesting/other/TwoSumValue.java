package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2020/8/3 15:07
 */
public class TwoSumValue {

    /*
    a={1,3,4,5}, x+y =m,m =8,求有多少种xy
     */

    @Test
    public void t1() {
        getSize(new int[]{1,1,1,2,2,2,3,4,4,4,5,5,6,7},8);
    }

    public int getSize(int[] a, int m) {
        if (null == a || 0 == a.length) {
            return 0;
        }

        Set<String> result = new HashSet<>();
        int left = 0, right = a.length - 1;
        while (left < right) {
            int temp = a[left] + a[right];
            if (temp == m) {
                String s = a[left] + "," + a[right];
                result.add(s);
                left++;
            } else if (temp < m) {
                left++;
            } else {
                right--;
            }
        }
        StringUtil.printObject(result);
        return result.size();
    }

}
