package demo.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i=0;i<1000;i++){
//			new Thread(new MyThread("testThread"+Integer.toString(i))).start();
//			MyThreadPool.getInstance().start(new MyThread("testThread"+Integer.toString(i)));
			ExecutorService service = Executors.newCachedThreadPool();
			service.execute(new MyThread("testThread"+Integer.toString(i)));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("time:"+Long.toString(endTime-startTime));

	}

}
