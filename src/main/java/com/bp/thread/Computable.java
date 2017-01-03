package com.bp.thread;

/**
 * @author current_bp
 * @createTime 20170103
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
