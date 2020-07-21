package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/7/19 17:02
 */
public class MoreMoney {
    /*
    很久之前，有个国王有三（n）个女儿，有三（n）位王子来求婚，每位王子只能且必定娶到一个公主，
    国王有权选择哪个女儿嫁给哪个王子，国王让他们按对每个公主的喜欢程度给出彩礼数，请写一个计算函数，
    并在main函数中调用，通过输入(通过代码定义即可)每位王子对每个公主的彩礼数，
    计算出国王如何嫁女儿可以获得最大的彩礼数，并将结果打印出来
     */

    //王子选择的公主，王子是index，公主是choose[index]
    private int[] choose = new int[3];
    int[][] eachMoneys = new int[][]{{1, 2, 3}, {3, 2, 1}, {4, 1, 3}};

    int maxMoney = 0;
    private int[] maxMoneyChoose = new int[3];

    @Test
    public void t1() {

        getTotalMoney(0);
        StringUtil.printObject("最大金额:" + maxMoney);
        StringUtil.printObject(maxMoneyChoose);
    }

    private void getTotalMoney(int index) {
        if (index >= 3) {//判断是否最大金额，如果是最大金额，就记录当前最大金额和选择
            doMax();
            return;
        }

        for (int i = 0; i < 3; i++) {
            choose[index] = i;//将每个公主供王子选择一次
            if (isOk(index)) {//能否选择该公主
                getTotalMoney(index+1);
            }
        }
    }

    private void doMax() {
        int tempMax = 0;
        int[] tempMaxMoneyChoose = new int[3];

        for (int i = 0; i < 3; i++) {
            int eachChoose = choose[i];//i个王子选择的公主
            tempMax += eachMoneys[i][eachChoose];
            tempMaxMoneyChoose[i] = eachChoose;
        }
        if (maxMoney >= tempMax) {
            return;
        }

        maxMoney = tempMax;
        maxMoneyChoose = tempMaxMoneyChoose;
    }

    /**
     * 判断这个王子能否选择该公主
     */
    private boolean isOk(int index) {
        if (index >= 3) {
            return true;
        }

        for (int i = 0; i < index; i++) {
            if (choose[i] == choose[index]) {
                return false;
            }
        }
        return true;
    }


}
