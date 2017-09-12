package demo.guardSuspentionDemo;

public class ClientThread extends Thread{
	private RequestQueue queue;
	
	public ClientThread(String name,RequestQueue queue){
		super(name);
		this.queue = queue;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			Request request = new Request("RequestId:"+i+",ThreadName:"+Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName()+":"+request);
			queue.addRequest(request);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println("ClientThreadName:"+Thread.currentThread().getName()+":"+request);
		}
		System.out.println(Thread.currentThread().getName()+":request end");
		
	}
}
