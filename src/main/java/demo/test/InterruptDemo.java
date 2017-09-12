package demo.test;

public class InterruptDemo {

	public static void main(String[] args) {

		SleepThread sleepThread = new SleepThread();
		sleepThread.start();
		boolean rs = sleepThread.isInterrupted();
		System.out.println("before: " + rs);
		sleepThread.interrupt();
		rs = sleepThread.isInterrupted();
		System.out.println("after: " + rs);
		sleepThread.interrupt();
		rs = sleepThread.isInterrupted();
		System.out.println("after2: " + rs);
	}

}

class SleepThread extends Thread {

	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace(System.out);
			}
		}
	}
}
