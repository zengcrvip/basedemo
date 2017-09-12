package demo.masterworkerDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//任务队列
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	//worker进程队列
	protected Map<String ,Thread> threadMap = new HashMap<String,Thread>();
	//子结果集队列
	protected Map<String ,Object> resultMap = new ConcurrentHashMap<String,Object>();
	
	public Master(Worker worker,int countWorker){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for(int i=0;i<countWorker;i++){
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	
	//是否所有的子任务都结束了
	public boolean isComplete(){
		for(Map.Entry<String ,Thread> entry:threadMap.entrySet()){
			if(entry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}
	
	//提交一个任务
	public void submit(Object obj){
		workQueue.add(obj);
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	
	public void execute(){
		for(Map.Entry<String ,Thread> entry:threadMap.entrySet()){
			entry.getValue().start();
		}
	}
	 
	
	
       
	
}
