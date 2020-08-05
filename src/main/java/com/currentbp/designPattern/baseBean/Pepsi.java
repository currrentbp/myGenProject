package com.currentbp.designPattern.baseBean;

/**
 * @author baopan
 * @createTime 2020/8/2 12:50
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
