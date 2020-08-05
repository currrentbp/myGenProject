package com.currentbp.designPattern.baseBean;

/**
 * 正方形
 * @author baopan
 * @createTime 2020/8/2 11:34
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square ::draw() method.");
    }
}
