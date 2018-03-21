package demo.javaconcurrentshizhan.chap1;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by changrong.zeng on 2017/12/28.
 */
public class Memoizer4<A,V> implements Computable<A,V> {
    private final Map<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
    private final Computable<A,V> c;

    public Memoizer4(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        while (true){
            Future<V> f = cache.get(arg);
            if(f == null){
                Callable<V> callable = new Callable<V>() {
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(callable);
                f = cache.putIfAbsent(arg,ft);
                if(f == null){
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
