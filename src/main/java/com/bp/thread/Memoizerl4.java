package com.bp.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author current_bp
 * @createTime 20170103
 */
public class Memoizerl4<A,V> implements Computable<A,V>{

    private final Map<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A,V> c;

    public Memoizerl4(Computable<A,V> c){
        this.c = c;
    }



    public  V compute(final A arg) throws InterruptedException {
        while(true) {
            Future<V> f = cache.get(arg);
            if (null == f) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };

                FutureTask<V> ft = new FutureTask<V>(eval);
                //此处注释，原因因为编译不过去，，，
                f = cache.putIfAbsent(arg,ft);

                if(null == f){
                    f = ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            }catch (CancellationException e1){
                //此处注释，原因因为编译不过去，，，
                cache.remove(arg,f);
            } catch (Exception e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}


