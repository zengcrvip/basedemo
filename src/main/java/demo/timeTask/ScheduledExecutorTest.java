package demo.timeTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 对于Timer的缺陷，我们可以考虑 ScheduledThreadPoolExecutor 来替代。Timer是基于绝对时间的，对系统时间比较敏感，
 * 而ScheduledThreadPoolExecutor 则是基于相对时间；
 * Timer是内部是单一线程，而ScheduledThreadPoolExecutor内部是个线程池，所以可以支持多个任务并发执行。
 * 如果是Timer，参照下面的TimerTest
 * @author 14111638
 *
 */
public class ScheduledExecutorTest {
	private ScheduledExecutorService scheduExec;
	public long start;

	ScheduledExecutorTest() {
		this.scheduExec = Executors.newScheduledThreadPool(2);
		this.start = System.currentTimeMillis();
	}

	public void timerOne() {
		scheduExec.schedule(new Runnable() {
			public void run() {
				System.out.println("timerOne,the time:"
						+ (System.currentTimeMillis() - start));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 1000, TimeUnit.MILLISECONDS);
	}

	public void timerTwo() {
		scheduExec.schedule(new Runnable() {
			public void run() {
				System.out.println("timerTwo,the time:"
						+ (System.currentTimeMillis() - start));
			}
		}, 20, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) {
		ScheduledExecutorTest test = new ScheduledExecutorTest();
//		test.timerOne();
		test.timerTwo();
	}
}


/**
 * 按照我们正常思路，timerTwo应该是在3s后执行，其结果应该是：timerOne invoked ,the time:1001timerOne invoked ,the time:3001
 * 但是事与愿违，timerOne由于sleep(4000)，休眠了4S，同时Timer内部是一个线程，导致timeOne所需的时间超过了间隔时间，结果：
 * timerOne invoked ,the time:1000timerOne invoked ,the time:5000
 * @author 14111638
 *
 */
/**
public class TimerTest {
	private Timer timer;
	public long start;
	
	public TimerTest04(){
		this.timer = new Timer(); 
		start = System.currentTimeMillis();
		} 
	
	public void timerOne(){ 
		timer.schedule(new TimerTask() {
			public void run(){  
				  System.out.println("timerOne invoked ,the time:" + (System.currentTimeMillis() - start)); 
			      try {     
			    	  Thread.sleep(4000);    //线程休眠4000                
			    	  } catch (InterruptedException e) {e.printStackTrace();} }
			}, 1000);
		}  
	
	
	public void timerTwo(){ 
		timer.schedule(new TimerTask() {  
			public void run() {
				System.out.println("timerOne invoked ,the time:" + (System.currentTimeMillis() - start));
				}
			}, 3000); 
		}   
	
	  public static void main(String[] args) throws Exception { 
		  TimerTest04 test = new TimerTest04();
		  test.timerOne(); 
		  test.timerTwo();
	  }
}
*/