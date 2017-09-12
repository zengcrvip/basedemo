package demo.threadPool;

import java.util.List;
import java.util.Vector;

public class MyThreadPool {
	private static MyThreadPool instance = null;
	private List<PThread> idleThreads;
	private int threadCount;
	private boolean isShutDown = false;
	
	private MyThreadPool(){
		this.idleThreads = new Vector(5);
		threadCount = 0;
	}
	
	public  synchronized static MyThreadPool getInstance(){
		if(instance == null){
			instance = new MyThreadPool();
		}
		return instance;
	}
	
	public int getCreatedThreadCount(){
		return threadCount;
	}
	
	//将线程放入池中
	protected synchronized void repool(PThread repoolingThread){
		if(!isShutDown){
			idleThreads.add(repoolingThread);
		}else{
			repoolingThread.shutDown();
		}
	}
	
	public synchronized void shutdown(){
		isShutDown = true;
		for(PThread pThread:idleThreads){
			pThread.shutDown();
		}
	}
	
	public synchronized void start(Runnable target){
		PThread thread = null;
		if(idleThreads.size() > 0){
			int lastIndex = idleThreads.size() -1;
			thread = idleThreads.get(lastIndex);
			idleThreads.remove(lastIndex);
			thread.setTarget(target);
		}else{
			threadCount++;
			thread = new PThread(target,"MyPThread"+threadCount,this);
			thread.start();
		}
	}
	
	

}
