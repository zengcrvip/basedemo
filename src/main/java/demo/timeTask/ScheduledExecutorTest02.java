package demo.timeTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * ScheduledThreadPoolExecutor内部是个线程池，所以可以支持多个任务并发执行。Timer是内部是单一线程
 * @author 14111638
 *
 */
public class ScheduledExecutorTest02 {
	private ScheduledExecutorService scheduExec;
	public long start;

	ScheduledExecutorTest02() {
		this.scheduExec = Executors.newScheduledThreadPool(2);
		this.start = System.currentTimeMillis();
	}

	public void timerOne() {
		scheduExec.schedule(new Runnable() {
			public void run() {
				throw new RuntimeException();
			}
		}, 1000, TimeUnit.MILLISECONDS);
	}

	public void timerTwo() {
		scheduExec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("timerTwo invoked .....");
			}
		}, 2000, 500, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) {
		ScheduledExecutorTest02 test = new ScheduledExecutorTest02();
		test.timerOne();
		test.timerTwo();
	}
}


/**
 * Timer抛出异常缺陷
          如果TimerTask抛出RuntimeException，Timer会终止所有任务的运行
 * @author 14111638
 *
 */
/**
public class TimerTest04 {
	private Timer timer;

	public TimerTest04() {
		this.timer = new Timer();
	}

	public void timerOne() {
		timer.schedule(new TimerTask() {
			public void run() {
				throw new RuntimeException();
			}
		}, 1000);
	}

	public void timerTwo() {
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("我会不会执行呢？？");
			}
		}, 1000);
	}

	public static void main(String[] args) {
		TimerTest04 test = new TimerTest04();
		test.timerOne();
		test.timerTwo();
	}
}
*/