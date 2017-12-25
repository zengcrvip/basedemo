package demo.myjdk6.util;

/**
 * 迭代器
 * Created by changrong.zeng on 2017/12/6.
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();

}
