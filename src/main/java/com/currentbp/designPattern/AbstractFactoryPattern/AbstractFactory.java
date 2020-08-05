package com.currentbp.designPattern.AbstractFactoryPattern;

import com.currentbp.designPattern.baseBean.Color;
import com.currentbp.designPattern.baseBean.Shape;

public interface AbstractFactory {
    public abstract Color getColor(int color);
    public abstract Shape getShape(int shape) ;
}
