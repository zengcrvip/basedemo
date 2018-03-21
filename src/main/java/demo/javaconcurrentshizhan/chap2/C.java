package demo.javaconcurrentshizhan.chap2;

import java.util.concurrent.Callable;

/**
 * Created by changrong.zeng on 2017/12/29.
 */
public class C implements Callable {
    public String call() throws Exception {
        //休眠8秒
        Thread.sleep(8000);
        System.out.println("任务C休眠时间是8秒");
        return "C is end";
    }
}
