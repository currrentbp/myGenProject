package com.currentbp.designPattern.strategyPattern;

public class OneIstrategy implements IStrategy{
    @Override
    public void doSomeThing() {
        System.out.println("doSomeThing, this is one");
    }
}
