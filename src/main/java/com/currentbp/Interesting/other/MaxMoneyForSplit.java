package com.currentbp.Interesting.other;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20220824
 */
public class MaxMoneyForSplit {
    /*
钢条长度和价格如下，求最大收益
L:  1       2       3       4       5       6       7       8       9       10
P:  1       5       8       9       10      17      17      20      24      30
E:  1.0     2.5     2.667   2.25    2.0     2.833   2.4285  2.5     2.667   3.0

按照效益排名：n：10,6,3,2,7,4,5,1

参考博客：https://blog.csdn.net/u013309870/article/details/75193592
     */

    private static int[] p = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    @Test
    public void t1() {
//        System.out.println(cut1(4));
//        System.out.println(cut2(11));
        System.out.println(cut3(11));
    }

    private int cut3(int n) {
        List<Pair<Integer, Integer>> kvs = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            Pair<Integer, Integer> kv = Pair.of(p[i], i + 1);
            kvs.add(kv);
        }
        List<Pair<Integer, Integer>> kvs2 = kvs.stream().sorted(Comparator.comparing(x -> -1 * (x.getKey() * 1.0f) / x.getRight())).collect(Collectors.toList());
        int remain = n;
        int result = 0;
        for (Pair<Integer, Integer> kv : kvs2) {
            Integer price = kv.getLeft();
            Integer index = kv.getRight();
            int used = remain / index;
            remain = remain % index;

            result += used * price;
        }
        return result;
    }

    private int cut1(int n) {
        if (n == 0) {
            return 0;
        }
        int q = 0;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i - 1] + cut1(n - i));
        }
        return q;
    }

    private int cut2(int n) {
        Map<Integer, Integer> num2PriceMap = new HashMap<>();
        num2PriceMap.put(0, 0);
        num2PriceMap.put(1, 1);
        for (int i = 1; i <= n; i++) {
            doCut2(num2PriceMap, i);
        }
        return num2PriceMap.getOrDefault(n, 0);
    }

    /*
    r = max(r1+rn-1,r2+rn-2,...,rn-1+r1);
     */
    private void doCut2(Map<Integer, Integer> num2PriceMap, int n) {
        if (n < 2) {
            return;
        }
        int max = 0;
        for (int i = 0; i <= (n / 2) + 1; i++) {
            Integer r_i = num2PriceMap.get(i);
            Integer r_n_i = num2PriceMap.get(n - i);
            //长度为i时最大价格是存在的，不存在时需要计算
            if (r_i == null) {
                if (i <= p.length) {
                    r_i = p[i - 1];
                } else {
                    r_i = 0;
                }
            }
            if (r_n_i == null) {
                if (n - i <= p.length) {
                    r_n_i = p[(n - i) - 1];
                } else {
                    r_n_i = 0;
                }
            }
            max = Math.max(r_i + r_n_i, max);
        }
        num2PriceMap.put(n, max);
    }

    public static int buttom_up_cut(int[] p) {
        int[] r = new int[p.length + 1];
        for (int i = 1; i <= p.length; i++) {
            int q = -1;
            //
            for (int j = 1; j <= i; j++)
                q = Math.max(q, p[j - 1] + r[i - j]);
            r[i] = q;
        }
        return r[p.length];
    }

}
