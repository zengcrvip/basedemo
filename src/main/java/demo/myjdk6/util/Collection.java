package demo.myjdk6.util;

/**
 *  顶层容器接口
 * Created by changrong.zeng on 2017/12/6.
 */
public interface Collection<E> {
    /**
     * 获取collection的大小
     * @return
     */
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Iterator<E> iterator();
    Object[] toArray();
    <T> T[] toArray(T[] a);
    boolean add(E e);
    boolean remove(Object o);
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);

    /**
     * 保留指定的元素
     * @param c
     * @return
     */
    boolean retainAll(Collection<?> c);
    void clear();
    boolean equals(Object o);
    int hashCode();
}
