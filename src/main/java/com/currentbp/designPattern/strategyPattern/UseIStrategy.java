package com.currentbp.designPattern.strategyPattern;

public class UseIStrategy {
    public IStrategy iStrategy;
    public UseIStrategy(IStrategy iStrategy){
        this.iStrategy = iStrategy;
    }
    public void useDoSomeThing(){
        this.iStrategy.doSomeThing();
    }
}
