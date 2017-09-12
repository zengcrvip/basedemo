package demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		
		String[] array = new String[]{"123","456","789"};
		
		ConcurrentHashMap m = new ConcurrentHashMap();
		
		
		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
		for(Map.Entry<String, String> entry:map.entrySet()){
			String val = entry.getValue();
			System.out.println(entry.getKey()+","+ val);
		}
		
		System.out.println("==========================set转换成list=======================================");
		//set转换成list，直接作为入参
		List<Map.Entry<String, String>> list =new ArrayList<Map.Entry<String,String>>(map.entrySet());
		
		System.out.println("==========================数组转换成list=======================================");
		//数组转换成list
		List<String>  arrayList = Arrays.asList(array);
		for(String str:arrayList){
			System.out.println(str);
		}
		
		System.out.println("============================List转换为set=====================================");
		//list转换为set,直接作为入参
		Set<String> strSet = new HashSet<String>(arrayList);
		Iterator setIt = strSet.iterator();
		while(setIt.hasNext()){
			System.out.println(setIt.next());
		}
		
		System.out.println("============================list转换成数组=====================================");
		//list转换成数组
		int size = arrayList.size();
		String[] strArray = arrayList.toArray(new String[size]);
		for(int i=0;i<strArray.length;i++){
			System.out.println(strArray[i]);
		}
		
		
		Set<String> sets = new HashSet<String>();

	}

}
