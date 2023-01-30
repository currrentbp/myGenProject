package com.currentbp.myMoney;

import com.currentbp.util.all.MoneyUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 1/26/2023 1:43 PM
 */
public class MyInterest {
    @Test
    public void trueInterest() {
        //从20年开始
        int[] years = new int[]{20, 21, 22, 23};
        float[] interest = new float[]{-0.1457f, 0.6024f, 0.1577f, 0.50f};//真实的炒股收益
        float[] bases = new float[]{6505, 4500, 20000, 10000};//真实的炒股本金投入金额
        double result = 0;
        int newScale = 2;
        double input = 0;
        System.out.printf("%s   %s    %s     %s      %s%n", "year", "年前投入", "年尾总额", "利差","今年投入");
        for (int i = 0; i < years.length; i++) {
            double currentMoney = MoneyUtil.add(result, bases[i]);
            double interestMoney = MoneyUtil.multiply(currentMoney, interest[i], newScale);
            result = MoneyUtil.add(currentMoney, interestMoney);
            input += bases[i];
            String format = String.format("%s  %9s  %9s  %9s %9s", years[i], input, result, interestMoney,bases[i]);
            System.out.println(format);
        }

    }
}
