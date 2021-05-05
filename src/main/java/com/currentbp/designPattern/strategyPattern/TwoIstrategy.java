package com.currentbp.designPattern.strategyPattern;

public class TwoIstrategy implements IStrategy{
    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing, this is two");
    }
}
