package demo.controller;

import java.util.HashMap;
import java.util.Map;

public class FInaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getMap().get("key").toString());
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("key", "value");
		result = null;
		System.out.println(result.get("key").toString());

	}
	
	
	public static Map<String,Object> getMap(){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("key", "init");
		try {
			result.put("key", "try");
			return result;
		} catch (Exception e) {
			result.put("key", "catech");
			
		}finally{
			result.put("key", "finally");
			result = null;
		}
		return result;
	}

}
