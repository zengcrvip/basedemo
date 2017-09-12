package demo.guardSuspentionDemo;

public class Request {
	private String name;
	
	public Request(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ Requet:"+ name +"]";
	}
	
	

}
