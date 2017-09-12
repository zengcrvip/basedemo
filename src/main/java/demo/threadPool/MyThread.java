package demo.threadPool;

public class MyThread implements Runnable{
	protected String name;
	public MyThread(){
		
	}
    public MyThread(String name){
		this.name = name;
	}
    
    public void run(){
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

}
