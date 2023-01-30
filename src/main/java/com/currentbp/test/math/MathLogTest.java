package com.currentbp.test.math;

import com.currentbp.util.all.MathUtil;
import com.currentbp.util.all.MoneyUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210105
 */
public class MathLogTest {

    @Test
    public void t4() {
        String x = " can not join this group, reason:user: staging_100031 already in group: 165576711405569";
        System.out.println(x.contains("already in group"));
    }

    @Test
    public void t1() {
        System.out.println(Math.log10(5));
        System.out.println(((int) Math.floor(Math.log10(5))));
        String x = "2222" + "_" + null;
        System.out.println(x);
    }

    @Test
    public void t2() {
//        System.out.println("中奖概率："+ MathUtil.c(5,32)*MathUtil.c(2,12));
//        System.out.println("中奖概率："+ (MathUtil.c(5,32)*MathUtil.c(2,12))/(1.0*MathUtil.c(5,22)*MathUtil.c(2,8)));
        System.out.println("中奖概率1：21425712  " + (22 * 21 * 20 * 19 * 18 * 7 * 4 / (5 * 4 * 3 * 2)));
        System.out.println("中奖概率:  " + (21425712 / 737352));
        System.out.println("最差中奖概率:  " + (21425712 / (27 * 26 * 25 * 24 * 23 * 5 * 9 / (5 * 4 * 3 * 2))));
    }

    @Test
    public void t3() {
        double v = MathUtil.compoundInterest(8000, 0.12, 30);
        System.out.println(v);
        double v1 = MathUtil.compoundInterest3(3600, 0, 30, 3600, 2);
        System.out.println(v1 + " " + 3600 * 30 * 1.4);
        double v2 = MathUtil.compoundInterest3(10000, 0.12, 35, 10000, 2);
        System.out.println(v2);
    }

    @Test
    public void tempInterest() {
//        float[] all = new float[]{0.6f, 0.15f, 0.3f, 0.2f, 0.1f, -0.1f,0.03f,0.05f,0.12f,-0.2f,0.4f};//351121.79
//        float[] all = new float[]{0.6f, 0.15f, 0.12f, 0.11f, 0.1f, 0.12f,0.13f,0.19f,0.1f,0.02f,0.05f,0.2f,0.15f,0.02f};//634541.58
//        float[] all = new float[]{0.6f, 0.15f, 0.12f, 0.11f, 0.1f, 0.12f,0.13f,0.2f,0.1f,0.02f,0.05f,0.2f,0.15f,0.2f};//749299.1
//        float[] all = new float[]{0.6f, 0.15f, 0.12f, 0.11f, 0.1f, 0.12f,0.13f,0.2f,0.1f,0.02f,0.05f,0.2f,0.15f,0.2f,0.1f,0.02f,0.05f,0.09f};//1053075.79
        float[] all = new float[]{0.624f, 0.15f};//真实的炒股金额
        double result = 0;
        float base = 10000;
        float eachAdd = 10000;
        int newScale = 2;
        double input = base;
        for (int i = 0; i < all.length; i++) {
            result = MoneyUtil.add(MoneyUtil.multiply(MoneyUtil.add(result, base, newScale), MoneyUtil.add(1, all[i], newScale), newScale),
                    eachAdd, newScale);
            input += eachAdd;
        }
        System.out.println(result + " " + input);
    }

    @Test
    public void trueInterest() {
        //从20年开始
        int[] years = new int[]{20, 21, 22, 23};
        float[] interest = new float[]{-0.1457f, 0.6024f, 0.1577f, 0.30f};//真实的炒股收益
        float[] bases = new float[]{6505, 4500, 20000, 10000};//真实的炒股本金投入金额
        double result = 0;
        int newScale = 2;
        double input = 0;
        for (int i = 0; i < years.length; i++) {
            double currentMoney = MoneyUtil.add(result, bases[i]);
            result = MoneyUtil.add(currentMoney, MoneyUtil.multiply(currentMoney, interest[i], newScale));
            input += bases[i];
            System.out.println(years[i] + "\t" + input + "\t" + result);
        }

    }

}
