package demo.guardSuspentionDemo;

public class GuardSusentionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		for(int i=0;i<10;i++){
			new ServerThread("ServerThread"+i,requestQueue).start();
		}
		
		for(int i=0;i<10;i++){
			new ClientThread("ClientThread"+i,requestQueue).start();
		}

	}

}
