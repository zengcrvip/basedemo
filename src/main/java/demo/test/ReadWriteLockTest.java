package demo.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	private double price = 0;
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	public double getPrice() {
		lock.readLock().lock();
		double value = price;
		lock.readLock().unlock();
		return value;
	}

	public void setPrice(double price) {
		lock.writeLock().lock();
		this.price = price;
		lock.writeLock().unlock();
	}

	public static class Reader implements Runnable {
		ReadWriteLockTest test = null;

		public Reader(ReadWriteLockTest test) {
			this.test = test;
		}

		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " read: " + test.getPrice());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Writer implements Runnable {
		ReadWriteLockTest test = null;

		public Writer(ReadWriteLockTest test) {
			this.test = test;
		}

		public void run() {
			String name = Thread.currentThread().getName();
			double value = Math.random() * 10;
			System.out.println(name + " write: " + value);
			test.setPrice(value);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ReadWriteLockTest test = new ReadWriteLockTest();
		
		Writer writer = new Writer(test);
		for (int i = 0; i < 10; i++) {
			Thread thr = new Thread(writer);
			thr.setName("write-" + i);
			thr.start();
		}
		
		Reader reader = new Reader(test);
		for (int i = 0; i < 10; i++) {
			Thread thr = new Thread(reader);
			thr.setName("reader-" + i);
			thr.start();
		}
		
		
	}
}
