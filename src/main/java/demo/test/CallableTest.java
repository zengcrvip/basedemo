package demo.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
	
	public void test(){
		MyCallable myCallable = new MyCallable();
		FutureTask<Object> task = new FutureTask<Object>(myCallable);
		Thread thread = new Thread(task);
		thread.start();
	}
	
	class MyCallable implements Callable<Object>{

		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class SomeCallable implements Callable<Object> {
	    public Object call() throws Exception {
	      // do something here
	      return null;
	    }
	  }


}




