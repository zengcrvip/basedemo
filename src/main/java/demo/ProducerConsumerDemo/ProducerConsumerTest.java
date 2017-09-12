package demo.ProducerConsumerDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerTest {
	private static final int SLEEPTIME = 1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer1);
		service.execute(consumer2);
		service.execute(consumer3);
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producer1.stop();
		producer2.stop();
		producer3.stop();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();

	}

}
