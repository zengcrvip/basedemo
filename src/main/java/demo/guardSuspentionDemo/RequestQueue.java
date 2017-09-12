package demo.guardSuspentionDemo;

import java.util.LinkedList;

public class RequestQueue {
	private LinkedList<Request> queue = new LinkedList<Request>();
	
	//获取请求
	public synchronized Request getRequest(){
		while(queue.size() == 0){
			try {this.wait();} catch (InterruptedException e) {}
		}
		return queue.remove();
	}
	
	//增加请求
	public synchronized void addRequest(Request request){
		queue.add(request);
		this.notifyAll();
	}

}
