package com.currentbp.designPattern.AbstractFactoryPattern;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/2 12:17
 */
public class FactoryProducer {

    @Test
    public void t1(){
        AbstractFactory factory = getFactory(1);
        factory.getShape(1).draw();
        factory.getShape(2).draw();
        factory.getShape(3).draw();

        AbstractFactory factory2 = getFactory(2);
        factory2.getColor(1).fill();
        factory2.getColor(2).fill();
        factory2.getColor(3).fill();
    }


    public static AbstractFactory getFactory(int choice){
        if(1== choice){
            return new ShapeFactory();
        } else if(2 == choice){
            return new ColorFactory();
        }
        return null;
    }
}
