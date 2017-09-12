package demo.masterworkerDemo;

import java.util.HashMap;
import java.util.Map;

public class STerst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int res = 0;
//		
//		for(int i=0;i<10;i++){
//			res += i*i*i;
//		}
//		
//		System.out.println("res="+res);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		
		for(Map.Entry<String, String> entry:map.entrySet()){
			System.out.println(entry.getValue());
			
			System.out.println(entry.getKey());
			System.out.println("=================================");
		}

	}

}
