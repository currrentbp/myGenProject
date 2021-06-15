package com.currentbp.designPattern.decoratorPattern;

public class TankGame {
    public static void main(String[] args) {
//        CommentTank tank = new DoubleTank();
        CommentTank tank = new FastTank();
        tank.move();
        tank.battle();
    }
}
