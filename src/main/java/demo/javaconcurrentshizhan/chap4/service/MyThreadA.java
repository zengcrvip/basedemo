package demo.javaconcurrentshizhan.chap4.service;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 16:48 2018/4/9 .
 */
public class MyThreadA extends Thread{
    private MyService myService;

    public MyThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}
