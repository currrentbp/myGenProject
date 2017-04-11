package com.bp.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by issuser on 2017/4/7.
 */
public class BooleanTestTest {
    private BooleanTest booleanTest = new BooleanTest();

    @Test
    public void simpleTypeHasDefaultValue() throws Exception {
        booleanTest.simpleTypeHasDefaultValue();
    }

    @Test
    public void eachOperatorResult(){
        booleanTest.eachOperatorResult();
    }

}