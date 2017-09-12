package demo.guardSuspentionDemo;

public class ServerThread extends Thread{
	private RequestQueue queue;
	
	public ServerThread(String name,RequestQueue queue){
		super(name);
		this.queue = queue;
	}
	

	@Override
	public void run() {
		while(true){
			final Request request = queue.getRequest();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName()+":============"+request);
		}
	}
	
	

}
