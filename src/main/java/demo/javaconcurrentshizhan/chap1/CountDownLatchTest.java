package demo.javaconcurrentshizhan.chap1;

import java.util.concurrent.CountDownLatch;

/**
 * 创建10个线程并发执行指定任务，
 * 程序使用了两个闭锁，开始信号（startSignal），初始值为1；结束信号（startSignal），初始值为线程数
 * 每个工作线程启动时首先在开始信号上等待，从而确保所有线程都就绪后才执行
 * 每个线程执行完后，结束信号减1，这能使主线程一直等待直到所有的工作线程执行完毕，因此可以统计所有工作线程的执行时间
 * Created by changrong.zeng on 2017/12/13.
 */
public class CountDownLatchTest {
    public static final int nThreads = 10;
    public static final CountDownLatch startSignal = new CountDownLatch(1);
    public static final CountDownLatch endSignal = new CountDownLatch(nThreads);


    public static void main(String[] args) {
        for(int i=0;i<nThreads;i++){
            new Thread(new Worker(startSignal,endSignal)).start();
        }
        long startTime = System.nanoTime();
        startSignal.countDown();  //开始信号减1，这时候AQS的state为0，所有线程竞争CPU开始执行
        try {
            endSignal.await();    //结束信号一直在主线程中等待，直到所有工作线程执行完AQS state为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("10个线程同时执行到全部都执行结束耗时："+ (endTime - startTime));
    }
}

class Worker implements Runnable{
    public final CountDownLatch startSignal;
    public final CountDownLatch endSignal;

    public Worker(CountDownLatch startSignal,CountDownLatch endSignal) {
        this.startSignal = startSignal;
        this.endSignal =   endSignal;
    }

    public void run() {
        try {
            startSignal.await();  //每个线程执行时，在此处等待
            doSomeThing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            endSignal.countDown();  //线程执行完后，结束信号减1
        }
    }

    public void doSomeThing(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
