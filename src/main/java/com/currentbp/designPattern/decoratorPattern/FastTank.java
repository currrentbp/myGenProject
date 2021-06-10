package com.currentbp.designPattern.decoratorPattern;

public class FastTank extends CommentTank{
    @Override
    public void move(){
        super.move();
        System.out.println("加速移动");
    }
    @Override
    public void battle(){
        super.battle();
    }
}
