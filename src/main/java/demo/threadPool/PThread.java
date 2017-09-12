package demo.threadPool;

public class PThread extends Thread{
	//线程池
	private MyThreadPool pool;
	//任务
	private Runnable target;
	private boolean isShutDown = false;
	private boolean isIdle = false;
	
	public PThread(Runnable target,String name,MyThreadPool pool){
		super(name);
		this.pool = pool;
		this.target = target;
	}

	public Runnable getTarget() {
		return target;
	}

	public boolean isIdle() {
		return isIdle;
	}
	
	public void run(){
		while(!isShutDown){
			isIdle = false;
			if(target != null){
				target.run();
			}
			isIdle = true;
			
			try {
				pool.repool(this);
				synchronized(this){
					wait();
				}
			} catch (InterruptedException e) {
				
			}
			isIdle = false;
		}
	}
	
	public synchronized void setTarget(Runnable newTarget){
		this.target = newTarget;
		notifyAll();
	}
	
	public synchronized void shutDown(){
		isShutDown = true;
		notifyAll();
	}

}
