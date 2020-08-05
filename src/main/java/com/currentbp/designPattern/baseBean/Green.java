package com.currentbp.designPattern.baseBean;

/**
 * @author baopan
 * @createTime 2020/8/2 12:07
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
