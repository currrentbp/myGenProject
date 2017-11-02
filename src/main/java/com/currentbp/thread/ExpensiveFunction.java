package com.currentbp.thread;

import java.math.BigInteger;

/**
 * @author current_bp
 * @createTime 20170103
 */
public class ExpensiveFunction implements Computable<String,BigInteger>{

    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}