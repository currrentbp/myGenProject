package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 给定一个数组B，最大值就是山峰，求山峰的总长度
 * 使得B0<B1<B2<Bi>Bi+1
 * 例如:[2,1,4,7,3,2,5]，其最大山峰长度是5,即[1,4,7,3,2]
 *
 * @author baopan
 * @createTime 2020/7/22 12:15
 */
public class MountainPeaks {

    @Test
    public void t1() {
        int[] m = new int[]{2, 1, 4, 7, 3, 2, 5};
        int length = getMountainLength(m);
        StringUtil.printObject(length);
    }

    @Test
    public void t2() {
        int[] m = new int[]{2, 1, 4, 7, 3, 2, 5};
        int length = getMountainLength2(m);
        StringUtil.printObject(length);
    }

    private int getMountainLength2(int[] m) {//TODO notwork 思路就是判断是否上下坡成对，不是，则重新计算
        int result = 0;
        //-1：左边数小于右边数，0：左边数字等于右边数字， 1：左边数字大于右边数字，
        //该值还有一个含义就是上一个阶段是
        int beforeFlag = m[0] < m[1] ? -1 : m[0] == m[1] ? 0 : 1;//才开始
        int currentFlag = m[0] < m[1] ? -1 : m[0] == m[1] ? 0 : 1;

        for (int left = 0, right = 1; right < m.length; ) {
            //只有两种情况才参与计算山长，1、beforeFlag=-1 && currentFlag = -1,2、beforeFlag = -1 && currentFlag=1,
            //而第二种情况需要将山长计算出来，其他的都直接不参与计算长度，直接跳过(将左节点调到右节点，右节点=原右节点+1)
            if (-1 == beforeFlag) {
                if (currentFlag != 1 && m[right - 1] < m[right]) {//还是在走上坡路
                } else if (m[right - 1] > m[right]) {//从上坡路到下坡路了
                    currentFlag = 1;
                    result = Math.max(result, right - left + 1);
                } else {
                    left = right;

                }
            }
            if (-1 == beforeFlag && 1 == currentFlag) {
                if (m[right - 1] > m[right]) {

                }
            }


            right++;
        }


        return result;
    }

    private int getMountainLength(int[] m) {
        int result = 0;
        for (int index = 1; index < m.length - 1; index++) {
            int leftLength = doLeft(m, index);
            if (leftLength == 0) {
                continue;
            }
            int rightLength = doRight(m, index);
            if (rightLength == 0) {
                continue;
            }
            result = Math.max(result, (leftLength + rightLength + 1));
        }
        return result;
    }

    private int doRight(int[] m, int index) {
        int result = 0;
        while (index < m.length) {
            if (m[index] <= m[index + 1]) {
                break;
            }
            result++;
            index++;
        }
        return result;
    }

    private int doLeft(int[] m, int index) {
        int result = 0;
        while (index > 0) {
            if (m[index] <= m[index - 1]) {
                break;
            }
            result++;
            index--;
        }
        return result;
    }

}
