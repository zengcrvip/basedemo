package demo.myjdk6.util;

/**
 * list迭代器
 * Created by changrong.zeng on 2017/12/6.
 */
public interface ListIterator<E> extends Iterator<E> {
    boolean hasNext();

    E next();

    boolean hasPrevious();

    E previous();

    int nextIndex();

    int previousIndex();

    void remove();

    void set(E e);

    void add(E e);
}
