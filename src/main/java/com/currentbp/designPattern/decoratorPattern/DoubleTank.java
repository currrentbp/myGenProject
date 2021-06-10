package com.currentbp.designPattern.decoratorPattern;

public class DoubleTank extends CommentTank{
    @Override
    public void move(){
        super.move();
    }
    @Override
    public void battle(){
        super.battle();
        System.out.println("双倍伤害攻击");
    }
}
