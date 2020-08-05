package com.currentbp.designPattern.baseBean;

/**
 * @author baopan
 * @createTime 2020/8/2 12:49
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
