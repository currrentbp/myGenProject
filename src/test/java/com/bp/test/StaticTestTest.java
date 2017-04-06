package com.bp.test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author current_bp
 * @createTime 20170406
 */
public class StaticTestTest {
    private StaticTest staticTest = new StaticTest();

    @Test
    public void diffFromObject2Class() throws Exception {
        staticTest.diffFromObject2Class();
    }

}