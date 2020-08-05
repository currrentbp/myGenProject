package com.currentbp.designPattern.baseBean;

/**
 * 圆形
 * @author baopan
 * @createTime 2020/8/2 11:34
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle ::draw() method.");
    }
}
