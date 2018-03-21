package demo.javaconcurrentshizhan.chap2;

import java.util.concurrent.Callable;

/**
 * Created by changrong.zeng on 2017/12/29.
 */
public class A implements Callable {

    public String call() throws Exception {
        //休眠一秒
        Thread.sleep(1000);
        System.out.println("任务A休眠时间是1秒");
        return "A is end";
    }
}
