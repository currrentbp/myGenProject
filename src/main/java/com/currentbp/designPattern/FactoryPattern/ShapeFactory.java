package com.currentbp.designPattern.FactoryPattern;

import com.currentbp.designPattern.baseBean.Circle;
import com.currentbp.designPattern.baseBean.Rectangle;
import com.currentbp.designPattern.baseBean.Shape;
import com.currentbp.designPattern.baseBean.Square;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/2 11:36
 */
public class ShapeFactory {

    @Test
    public void t1(){
        getShapeByType(1).draw();
        getShapeByType(2).draw();
        getShapeByType(3).draw();
    }

    public Shape getShapeByType(int type){
        if(1==type){
            return new Circle();
        }else if(2==type){
            return new Rectangle();
        }else{
            return new Square();
        }
    }
}
