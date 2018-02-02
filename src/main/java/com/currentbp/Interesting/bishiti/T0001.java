package com.currentbp.Interesting.bishiti;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * @author current_bp
 * @createTime 20180131
 */
public class T0001 {
    private final static Logger logger = LoggerFactory.getLogger(T0001.class);
    /*
    题目描述

在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。

给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。

测试样例：

[10,22,5,75,65,80],6

返回：

87
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.next();

        int index = source.lastIndexOf(",");
        String numStrs = source.substring(0, index);
        String lenStr = source.substring(index);
        logger.info("===>numStrs:" + numStrs + " lenStr:" + lenStr);

        List nums = JSON.parseObject(numStrs, List.class);


    }

}
