package demo.timeTask;

import java.util.Timer;

public class TimerTest01 {
	private Timer timer;
	
	public TimerTest01(int time){
		timer = new Timer();
		timer.schedule(new TimerTaskTest01(), time*1000);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Timer begin....");
		new TimerTest01(3);
		

	}

}
