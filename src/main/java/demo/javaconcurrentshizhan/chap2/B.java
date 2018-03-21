package demo.javaconcurrentshizhan.chap2;

import java.util.concurrent.Callable;

/**
 * Created by changrong.zeng on 2017/12/29.
 */
public class B implements Callable {

    public String call() throws Exception {
        //休眠一秒
        Thread.sleep(2000);
        System.out.println("任务B休眠时间是2秒");
        return "B is end";
    }
}
