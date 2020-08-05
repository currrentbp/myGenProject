package com.currentbp.designPattern.AbstractFactoryPattern;

import com.currentbp.designPattern.baseBean.*;

/**
 * @author baopan
 * @createTime 2020/8/2 12:12
 */
public class ShapeFactory implements AbstractFactory {
    @Override
    public Color getColor(int color) {
        return null;
    }

    @Override
    public Shape getShape(int shape) {
        if (1 == shape) {
            return new Circle();
        } else if (2 == shape) {
            return new Rectangle();
        } else {
            return new Square();
        }
    }
}
