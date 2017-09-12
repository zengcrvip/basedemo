package demo.ProducerConsumerDemo;

public final class PCData {
	private final int intData;
	public PCData(int data){
		intData = data;
	}
	public int getIntData() {
		return intData;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "data:"+intData;
	}
	

}
