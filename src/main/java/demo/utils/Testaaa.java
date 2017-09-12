package demo.utils;

public class Testaaa {
	
	public static  int hash(String key){
		int h = key.hashCode();
		h ^= (h>>>20) ^ (h>>>12);
		return h ^ (h >>> 7) ^ (h>>>4);
	}
	
	
	public static  int indexFor(int h,int length){
		int value = h & (length -1);
		return value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String key1 = "aaa";
		String key2 = "bbb";
		String key3 = "ccc";
		String key4= "ddd";
		
		int a = indexFor(hash(key1),10);
		int b = indexFor(hash(key2),10);
		int c = indexFor(hash(key3),10);
		int d = indexFor(hash(key4),10);
		
		System.out.println("a="+a+",b="+b+",c="+c+",d="+d);
		

	}

}
