package demo.javaconcurrentshizhan.chap1;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by changrong.zeng on 2017/12/14.
 */
public class Memoizer3<A,V> implements Computable<A,V> {
    public final Map<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    public final  Computable<A,V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if(f == null){
            Callable<V> eval = new Callable<V>() {
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg,ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
