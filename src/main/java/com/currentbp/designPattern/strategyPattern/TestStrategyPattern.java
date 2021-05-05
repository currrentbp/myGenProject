package com.currentbp.designPattern.strategyPattern;

import org.junit.Test;

public class TestStrategyPattern {
    @Test
    public void t1(){
        UseIStrategy useIStrategy1 = new UseIStrategy(new OneIstrategy());
        useIStrategy1.useDoSomeThing();
        UseIStrategy useIStrategy2 = new UseIStrategy(new TwoIstrategy());
        useIStrategy2.useDoSomeThing();
    }
}
