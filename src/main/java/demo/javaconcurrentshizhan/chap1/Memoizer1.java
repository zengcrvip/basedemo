package demo.javaconcurrentshizhan.chap1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by changrong.zeng on 2017/12/13.
 */
public class Memoizer1<A,V> implements Computable<A,V> {
    public final Map<A,V> cache = new HashMap<A, V>();
    public final Computable<A,V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
