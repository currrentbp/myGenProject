package com.currentbp.designPattern.baseBean;

/**
 * 矩形
 * @author baopan
 * @createTime 2020/8/2 11:34
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
