package demo.javaconcurrentshizhan.chap2;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by changrong.zeng on 2017/12/29.
 */
public class InvorkTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        List<Callable<String>> tasks = new ArrayList<Callable<String>>();
        tasks.add(new A());
        tasks.add(new B());
        tasks.add(new C());
        List<Future<String>> futures = service.invokeAll(tasks, 2000, TimeUnit.MILLISECONDS);
        Iterator<Callable<String>> iterator = tasks.iterator();
        for(Future<String> f : futures){
            Callable<String> callable = iterator.next();
            String str = null;
            try {
                str = f.get();
            } catch (ExecutionException e) {
                System.out.println("超时");
            } catch (CancellationException el){
                System.out.println("任务取消");
            }
            System.out.println(str);
        }

    }
}
