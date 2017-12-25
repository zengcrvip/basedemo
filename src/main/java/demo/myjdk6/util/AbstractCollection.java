package demo.myjdk6.util;

/**
 * 顶层容器Collection的抽象实现类
 * Created by changrong.zeng on 2017/12/6.
 */
public abstract class AbstractCollection<E> implements Collection<E>{
    //空构造器
    protected AbstractCollection(){};

    public abstract int size();

    public  boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        Iterator it = iterator();
        if(null == o){
            while (it.hasNext()){
                if(it.next() == null){
                    return true;
                }
            }
        }else{
            while (it.hasNext()){
                if(it.next().equals(o)){
                    return true;
                }
            }

        }
        return false;
    }

    public abstract Iterator<E> iterator();

    public Object[] toArray() {
        Object[] objects = new Object[size()];
        Iterator<E> it = iterator();
        for(int i=0;i<objects.length;i++){
            objects[i] = it.next();
        }
        return objects;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        if(null == o){
            while (it.hasNext()){
                if(null == it.next()){
                    it.remove();
                    return true;
                }
            }
        }else{
            while (it.hasNext()){
                if(o.equals(it.next())){
                    it.remove();
                    return true;
                }
            }
        }
        return false;

    }

    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()){
            if(!contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()){
            if(!add((E)iterator.next())){
                return false;
            }
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        boolean modify = false;
        Iterator<?> it = iterator();
        while (it.hasNext()){
            if(c.contains(it.next())){
                it.remove();
                modify = true;
            }
        }
        return modify;
    }

    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        Iterator<E> it = iterator();
        while (it.hasNext()){
            if(!c.contains(it.next())){
                it.remove();
                flag = true;
            }
        }
        return flag;
    }

    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()){
            it.remove();
        }
    }

    public String toString() {
        if(size() == 0){
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        Iterator<E> it = iterator();
        for(;;){
            stringBuffer.append(it.next());
            if(!it.hasNext()){
                return stringBuffer.append("]").toString();
            }else{
                stringBuffer.append(", ");
            }
        }
    }
}
