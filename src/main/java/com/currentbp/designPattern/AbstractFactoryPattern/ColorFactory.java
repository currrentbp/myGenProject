package com.currentbp.designPattern.AbstractFactoryPattern;

import com.currentbp.designPattern.baseBean.*;

/**
 * @author baopan
 * @createTime 2020/8/2 12:12
 */
public class ColorFactory implements AbstractFactory {
    @Override
    public Color getColor(int color) {
        if(1== color){
            return new Blue();
        }else if(2 == color){
            return new Green();
        }else {
            return new Red();
        }
    }

    @Override
    public Shape getShape(int shape) {
        return null;
    }
}
