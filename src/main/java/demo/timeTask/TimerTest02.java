package demo.timeTask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TimerTest02 {
	private Timer timer;
	
	public TimerTest02(){
		Date time = getTime();
		System.out.println("begin:"+time);
		timer = new Timer();
		timer.schedule(new TimerTaskTest02(), time,1000);
	}
	
	public Date getTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.HOUR_OF_DAY, 9);
		calendar.set(calendar.MINUTE, 30);
		calendar.set(calendar.SECOND, 00);
		return calendar.getTime();
	}
    
	public static void main(String[] args) {
		new TimerTest02();

	}

}
