package demo.test;

import java.util.concurrent.LinkedBlockingQueue;

public class WaitNotifyDemo {
	private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	
	public void produce(String name){
		String threadName = Thread.currentThread().getName();
		System.out.println("produce "+threadName+" is producing------ "+name);
		
		synchronized (this) {
			queue.add(name);
			this.notifyAll();
		}
	}
	
	public void consumer(){
		String value = null;
		if(queue.size() > 0){
			synchronized (this) {
				value = queue.poll();
				if(value != null){
					String threadName = Thread.currentThread().getName();
					System.out.println("consumer "+threadName+" is consumering------ "+value);
				}else{
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
		Produce produce = new Produce(waitNotifyDemo);
		for(int i=0;i<10;i++){
			Thread produceThread = new Thread(produce);
			produceThread.start();
		}
		
		Consumer consumer = new Consumer(waitNotifyDemo);
		for(int i=0;i<10;i++){
			Thread consumerThread = new Thread(consumer);
			consumerThread.start();
		}
	}
	
}

class Produce implements Runnable{
	private WaitNotifyDemo waitNotifyDemo = null;
	
	public Produce(WaitNotifyDemo waitNotifyDemo){
		this.waitNotifyDemo = waitNotifyDemo;
	}

	@Override
	public void run() {
		while(true){
			String result = "String-"+(int)(Math.random()*100);
			waitNotifyDemo.produce(result);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	private WaitNotifyDemo waitNotifyDemo = null;
	

	public Consumer(WaitNotifyDemo waitNotifyDemo) {
		super();
		this.waitNotifyDemo = waitNotifyDemo;
	}

	@Override
	public void run() {
		while(true){
			waitNotifyDemo.consumer();
		}
		
		
	}
	
}


