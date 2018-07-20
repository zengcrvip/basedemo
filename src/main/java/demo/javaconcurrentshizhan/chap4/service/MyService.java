package demo.javaconcurrentshizhan.chap4.service;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 16:10 2018/4/9 .
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void methodA(){
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA end ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void await(){
        try {
            lock.lock();
            System.out.println("await");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally");
            lock.unlock();
        }



    }




}
