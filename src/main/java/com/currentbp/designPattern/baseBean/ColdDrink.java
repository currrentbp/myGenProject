package com.currentbp.designPattern.baseBean;

/**
 * @author baopan
 * @createTime 2020/8/2 12:43
 */
public abstract  class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
