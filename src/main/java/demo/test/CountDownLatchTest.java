package demo.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

	public static void main(String[] args) {
		Meeting meeting = new Meeting(10);
		Thread meetingThread = new Thread(meeting);
		meetingThread.start();
		for (int i = 0; i < 10; i++) {
			Person person = new Person("Persion-" + i, meeting);
			Thread thr = new Thread(person);
			thr.start();
		}
	}

}

// 会议对象
class Meeting implements Runnable {

	// 参会者数目
	private int number = 0;

	// 会议管理员
	private CountDownLatch admin = null;

	public Meeting(int number) {
		super();
		this.number = number;
		admin = new CountDownLatch(this.number);
	}

	public void arrive(String name) {
		System.out.printf("%s has arrived.\n ", name);
		admin.countDown();
	}

	public void run() {
		System.out.printf("Wait...\n");
		try {
			admin.await();
			System.out.printf("All the people have come. ");
			System.out.printf("Meeting start!\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// 会议参加人
class Person implements Runnable {

	private String name = null;
	private Meeting meeting = null;

	public Person(String name, Meeting meeting) {
		super();
		this.name = name;
		this.meeting = meeting;
	}

	public void run() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		meeting.arrive(name);
	}
}
