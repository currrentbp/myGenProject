package com.currentbp.designPattern.baseBean;

/**
 * @author baopan
 * @createTime 2020/8/2 12:43
 */
public abstract class Burger  implements Item{
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
