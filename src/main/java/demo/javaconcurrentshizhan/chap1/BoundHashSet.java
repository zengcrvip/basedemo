package demo.javaconcurrentshizhan.chap1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by changrong.zeng on 2017/12/13.
 */
public class BoundHashSet {
    public static final Integer num = 100;
    public  final Set<String> set;
    public  final Semaphore semaphore;

    public BoundHashSet() {
        set = Collections.synchronizedSet(new HashSet<String>());
        semaphore = new Semaphore(num);
    }

    public boolean add(String s) throws InterruptedException{
        semaphore.acquire();
        boolean flag = false;
        try {
            flag = set.add(s);
            return flag;
        } finally {
            if(!flag){
                semaphore.release();
            }
        }
    }

    public boolean delete(String s){
        boolean flag = set.remove(s);
        if(flag){
            semaphore.release();
        }
        return flag;
    }

    public static void main(String[] args) {


    }
}
