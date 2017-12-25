package demo.myjdk6.util;

import java.io.Serializable;

/**
 * Created by changrong.zeng on 2017/12/7.
 */
public class ArrayList<E> extends AbstractList<E> implements List<E>,Serializable {

    private static final long serialVersionUID = 8683452581122892189L;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {

    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return super.listIterator(index);
    }

    @Override
    public ListIterator<E> listIterator() {
        return super.listIterator();
    }

    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o);
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public E remove(int index) {
        return super.remove(index);
    }

    @Override
    public void add(int index, E e) {
        super.add(index, e);
    }

    @Override
    public E set(int index, E e) {
        return super.set(index, e);
    }

    @Override
    public E get(int index) {
        return super.get(index);
    }

    @Override
    public boolean retainAll(Collection c) {
        return super.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return super.removeAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return super.addAll(index, c);
    }

    @Override
    public boolean add(Object o) {
        return super.add(o);
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
