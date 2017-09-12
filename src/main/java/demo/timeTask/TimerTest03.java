package demo.timeTask;

import java.util.Timer;

public class TimerTest03 {
	private Timer timer;
	
	public TimerTest03(){
		timer = new Timer();
		timer.schedule(new TimerTaskTest03(), 1000, 3000);
	}

	
	public static void main(String[] args) {
		new TimerTest03();

	}

}
