package demo.myjdk6.util;

/**
 * Created by changrong.zeng on 2017/12/6.
 */
public interface List<E> extends Collection<E>{

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(Object o);

    boolean remove(Object o);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index, Collection<? extends E> c);

    boolean removeAll(Collection c);

    boolean retainAll(Collection c);

    void clear();

    boolean equals(Object o);

    int hashCode();

    E get(int index);

    E set(int index, E e);

    void add(int index, E e);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    List<E> subList(int fromIndex, int toIndex);

}
