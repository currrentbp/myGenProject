package com.bp.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author current_bp
 * @createTime 20170103
 */
public class Memoizerl2<A,V> implements Computable<A,V>{

    private final Map<A,V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A,V> c;

    public Memoizerl2(Computable<A,V> c){
        this.c = c;
    }



    public  V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(null == result){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}


