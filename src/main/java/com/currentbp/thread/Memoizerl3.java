package com.currentbp.thread;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author current_bp
 * @createTime 20170103
 */
public class Memoizerl3<A,V> implements Computable<A,V>{

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A,V> c;

    public Memoizerl3(Computable<A,V> c){
        this.c = c;
    }



    public  V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if(null == f){
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };

            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;

            cache.put(arg, ft);
            ft.run();
        }

        try{
            return f.get();
        }catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }
}


