package demo.javaconcurrentshizhan.chap1;

/**
 * Created by changrong.zeng on 2017/12/13.
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
