package com.currentbp.test.gc.compile.init;

/**
 * @author current_bp
 * @createTime 20170818
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init！");
    }
}
