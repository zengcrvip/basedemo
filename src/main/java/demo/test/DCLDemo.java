package demo.test;

import java.util.LinkedList;

public class DCLDemo {

	public static void main(String[] args) {
		LinkedList<Object> queue = new LinkedList<Object>();

		for (int i = 0; i < 10; i++) {
			MsgConsumer consumer = new MsgConsumer(queue);
			consumer.setName("Consumer-" + i);
			consumer.start();
		}

		MsgProducer producer = new MsgProducer(queue);
		producer.start();
	}
}

class MsgProducer extends Thread {
	LinkedList<Object> queue = null;

	public MsgProducer(LinkedList<Object> queue) {
		super();
		this.queue = queue;
	}

	public void run() {

		while (true) {
			Object data = new Object();
			synchronized (queue) {
				queue.addLast(data);
				queue.notifyAll();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

class MsgConsumer extends Thread {
	LinkedList<Object> queue = null;

	public MsgConsumer(LinkedList<Object> queue) {
		super();
		this.queue = queue;
	}

	public void run() {
		Object data = null;
		while (true) {
			if (queue.size() > 0) {// ①进入同步块之前的检查
				synchronized (queue) {// ②获取queue对象的锁,进入同步块
					if (queue.size() > 0) {// ③重复检查
						data = queue.removeFirst();
					}
				}
				if (data != null) {
					// do something with data.
					String name = Thread.currentThread().getName();
					System.out.println(name + " has consumed msg.");
				}
			} else {
				synchronized (queue) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
