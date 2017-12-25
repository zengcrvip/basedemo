package demo.myjdk6.util;

/**
 * Created by changrong.zeng on 2017/12/6.
 */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>{

    protected AbstractList() {
    }

    public Iterator<E> iterator() {
        return null;
    }

    public boolean add(Object o) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E e) {
        return null;
    }

    public void add(int index, E e) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
