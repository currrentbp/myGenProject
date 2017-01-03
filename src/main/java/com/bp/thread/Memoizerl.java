package com.bp.thread;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author current_bp
 * @createTime 20170103
 */
public class Memoizerl<A,V> implements Computable<A,V>{

    private final Map<A,V> cache = new HashMap<A,V>();
    private final Computable<A,V> c;

    public Memoizerl(Computable<A,V> c){
        this.c = c;
    }



    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(null == result){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}

class ExpensiveFunction implements Computable<String,BigInteger>{

    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
